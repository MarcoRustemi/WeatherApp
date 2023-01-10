package at.ac.campuswien.weatherapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WeatherController {

    @FXML
    private TextField stateField;

    @FXML
    private void searchWeather() {
        String state = stateField.getText();
        String apiKey = "644660f15c460cd498ab3932a80a5b9b";

        String url = "https://api.weather.com/v3/wx/forecast/daily/5day?format=json&units=m&language=en-US&state=" + state + "&apiKey=" + apiKey;

        try {
            String jsonResponse = makeAPICall(url);
            // Parse JSON response to retrieve weather information
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String makeAPICall(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }
}




/*import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
}*/
