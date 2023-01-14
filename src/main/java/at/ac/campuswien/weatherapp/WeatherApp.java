package at.ac.campuswien.weatherapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class WeatherApp extends Application {

    private WeatherModel model;
    private WeatherView view;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource("app-view.fxml"));
        Parent root = fxmlLoader.load();
        this.view = (WeatherView) fxmlLoader.getController();
        Scene scene = new Scene(root, 1200, 800);
        stage.setTitle("WeatherApp");
        stage.setScene(scene);
        stage.show();
        this.model = new WeatherModel();
        setView();
        setListener();
    }

    public void setView(){
        String city = this.model.getCity();
        String date = this.model.getCurrDate();
        HashMap<Day, Double> temp = this.model.getTemperature();
        HashMap<Day, String> state = this.model.getState();

        this.view.setTemp(temp.get(Day.MONDAY), temp.get(Day.TUESDAY), temp.get(Day.WEDNESDAY), temp.get(Day.THURSDAY), temp.get(Day.FRIDAY), temp.get(Day.SATURDAY), temp.get(Day.SUNDAY));
        this.view.setImgPath(Day.MONDAY.getImgPath(), Day.TUESDAY.getImgPath(), Day.WEDNESDAY.getImgPath(), Day.THURSDAY.getImgPath(), Day.FRIDAY.getImgPath(), Day.SATURDAY.getImgPath(), Day.SUNDAY.getImgPath());
        this.view.setCityAndDate(city, date);
        this.view.setState(state.get(Day.MONDAY), state.get(Day.TUESDAY), state.get(Day.WEDNESDAY), state.get(Day.THURSDAY), state.get(Day.FRIDAY),state.get(Day.SATURDAY), state.get(Day.SUNDAY));
        this.view.setCityAndDate(city, date);
    }

    public void setListener(){
        Button b = this.view.getSearchButton();
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    search();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public void search() throws IOException {
        String city = this.view.getInput();
        this.model.loadCity(city);
        this.setView();
    }

    public static void main(String[] args) {
        launch();
    }
}