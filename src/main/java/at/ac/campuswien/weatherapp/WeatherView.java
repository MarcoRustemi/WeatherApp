package at.ac.campuswien.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class WeatherView {
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

    public void setTemp(Double monday, Double tuesday, Double wednesday, Double thursday, Double friday, Double saturday, Double sunday){
        tempMo.setText(monday.toString() + " °C");
        tempDi.setText(tuesday.toString() + " °C");
        tempMi.setText(wednesday.toString() + " °C");
        tempDo.setText(thursday.toString() + " °C");
        tempFr.setText(friday.toString() + " °C");
        tempSa.setText(saturday.toString() + " °C");
        tempSo.setText(sunday.toString() + " °C");
        /*
        Alle Textfelder entsprechend setzen
         */
    }

    public void setImgPath(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday){
        /*
        Alle IMGs entsprechend setzen und aktualisieren
         */
    }

    public void setCityAndDate(String city, String date){
        /*
        Stadt und Datum setzen
         */
    }

    public String getInput() {
        /*
        Return Eingabe TextField
         */
        return "";
    }
}

