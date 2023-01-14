package at.ac.campuswien.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class WeatherApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("WeatherApp");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        ApiConnector connector = new ApiConnector();
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "265aa588f98045e7933132318231001");
        map.put("q", "Paris");
        try {
            connector.connect(map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        launch();

    }
}