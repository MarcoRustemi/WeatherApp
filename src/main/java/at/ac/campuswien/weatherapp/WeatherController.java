package at.ac.campuswien.weatherapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.MalformedURLException;

public class WeatherController {

    @FXML
    private TextField city;

    @FXML
    private Text weatherOutput;

    private final String cityAPI = "https://api.openweathermap.org/data/2.5/forecast?id=524901&appid={d956a4bba747963b38b35352359883a0}";

    @FXML
    void getWeatherData(ActionEvent event) throws MalformedURLException {
    }
}
