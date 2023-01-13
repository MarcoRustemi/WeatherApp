package at.ac.campuswien.weatherapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class WeatherController {
    @FXML
    private Label zustMo, zustDi, zustMi, zustDo,zustFr,zustSa,zustSo; //fx:ids für Wetterzustaende(cloudy,rainy,sunny)Mo-So
    @FXML
    private Label tempMo, tempDi, tempMi,tempDo, tempFr,tempSa,tempSo; //fx:ids für temp Mo-So
    @FXML
    private ImageView imgMo,imgDi,imgMi,imgDo,imgFr,imgSa,imgSo;// fx:ids für icons Mo-So
    @FXML
    private TextField txtField;
    @FXML
    protected void onHelloButtonClick(){
        zustMo.setText("Cloudy");
        zustDi.setText("Cloudy");
        zustMi.setText("Cloudy");
        zustDo.setText("Cloudy");
        zustFr.setText("Cloudy");
        zustSa.setText("Cloudy");
        zustSo.setText("Cloudy");
        tempMo.setText("35°");
        tempDi.setText("35°");
        tempMi.setText("35°");
        tempDo.setText("35°");
        tempFr.setText("35°");
        tempSa.setText("35°");
        tempSo.setText("35°");
    }
}

