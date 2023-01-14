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
    private HashMap<String, String> params;
    final String key = "265aa588f98045e7933132318231001";
    private String city;
    private String currDate;

    public WeatherModel(){
        this.connector = new ApiConnector();
        this.temperature = new HashMap<>();
        this.currDate = new Date().toGMTString();
        this.params = new HashMap<>();
        // Standardcity -> Vienna
        params.put("key", key);
        params.put("days", "7");
        try {
            loadCity("Vienna");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadCity(String city) throws IOException {
        this.city = city;
        this.params.put("q", city);
        ApiResponse<Boolean, JSONArray> content = connector.connect(this.params);

        for (int i = 0; i < 7; i++) {
            JSONObject jsonObject = (JSONObject) content.getJson().get(i);
            Day day = getDay((String) jsonObject.get("date"));
            JSONObject jsonObject1 = (JSONObject) jsonObject.get("day");
            double temp = (double) jsonObject1.get("avgtemp_c");
            JSONObject icon = (JSONObject) jsonObject1.get("condition");
            String iconPath = "../../resources/Images" + ((String) icon.get("icon")).substring(20);
            day.setImgPath(iconPath);
            this.temperature.put(day, temp);
        }

        System.out.println(this.temperature.toString());
    }

    public Day getDay(String date){
        String[] array = date.split("-");
        int tag = Integer.parseInt(array[2]);
        int monat = Integer.parseInt(array[1]);
        int jahr = Integer.parseInt(array[0]);

        LocalDate d = LocalDate.of(jahr, monat, tag);
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


    public static void main(String[] args) {
        WeatherModel w = new WeatherModel();
    }
}
