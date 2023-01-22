package at.ac.campuswien.weatherapp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class WeatherModel {

    private ApiConnector connector;
    private HashMap<Day, Double> temperature;
    private HashMap<Day, String> state;
    private HashMap<String, String> params;
    final String key = "265aa588f98045e7933132318231001";
    private String city;
    private String currDate;

    public WeatherModel(){
        this.connector = new ApiConnector();
        this.temperature = new HashMap<>();
        this.params = new HashMap<>();
        this.state = new HashMap<>();
        // Standardcity -> Vienna
        params.put("key", key);
        params.put("days", "7");
        params.put("lang", "de");
        try {
            loadCity("Vienna");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ErrorResponse<Boolean, String> loadCity(String city) throws IOException{
        this.city = city;
        this.params.put("q", city);
        ApiResponse<Boolean, JSONArray> content = null;
        try {
            content = connector.connect(this.params);
            for (int i = 0; i < 7; i++) {
                JSONObject jsonObject = (JSONObject) content.getJson().get(i);
                Day day = getDay((String) jsonObject.get("date"));
                if (i == 0){
                    this.currDate = (String) jsonObject.get("date");
                }
                JSONObject jsonObject1 = (JSONObject) jsonObject.get("day");
                double temp = (double) jsonObject1.get("avgtemp_c");
                JSONObject condition = (JSONObject) jsonObject1.get("condition");
                String dir = System.getProperty("user.dir");
                String iconPath = dir + "/src/main/resources/Images" + ((String) condition.get("icon")).substring(20);
                day.setImgPath(iconPath);
                this.temperature.put(day, temp);
                this.state.put(day, (String) condition.get("text"));
            }
            return new ErrorResponse<>(Boolean.TRUE, null);
        } catch (ApiRespnseException e) {
            return (new ErrorResponse<>(Boolean.FALSE, e.getMessage()));
        }
    }

    public Day getDay(String date){
        String[] array = date.split("-");
        int day = Integer.parseInt(array[2]);
        int month = Integer.parseInt(array[1]);
        int year = Integer.parseInt(array[0]);

        LocalDate d = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = d.getDayOfWeek();

        switch (dayOfWeek.getValue()){
            case 1:
                return Day.MONDAY;
            case 2:
                return Day.TUESDAY;
            case 3:
                return Day.WEDNESDAY;
            case 4:
                return Day.THURSDAY;
            case 5:
                return Day.FRIDAY;
            case 6:
                return Day.SATURDAY;
            case 7:
                return Day.SUNDAY;
        }
        return null;
    }

    public int getDayAsNumber(){
        String[] array = currDate.split("-");
        int day = Integer.parseInt(array[2]);
        int month = Integer.parseInt(array[1]);
        int year = Integer.parseInt(array[0]);

        LocalDate d = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = d.getDayOfWeek();

        return dayOfWeek.getValue();
    }

    public HashMap<Day, Double> getTemperature() {
        return temperature;
    }

    public String getCity() {
        return city;
    }

    public String getCurrDate() {
        return currDate;
    }

    public HashMap<Day, String> getState(){
        return state;
    }
}
