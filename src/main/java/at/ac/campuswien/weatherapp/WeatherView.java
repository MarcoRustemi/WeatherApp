package at.ac.campuswien.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;


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
    private Button searchButton;

    @FXML
    protected void onHelloButtonClick(){
        //zustMo.setText("Cloudy");
    }

    public Button getSearchButton(){
        return searchButton;
    }

    public void setTemp(Double monday, Double tuesday, Double wednesday, Double thursday, Double friday, Double saturday, Double sunday){
        tempMo.setText(monday.toString() + " °C");
        tempDi.setText(tuesday.toString() + " °C");
        tempMi.setText(wednesday.toString() + " °C");
        tempDo.setText(thursday.toString() + " °C");
        tempFr.setText(friday.toString() + " °C");
        tempSa.setText(saturday.toString() + " °C");
        tempSo.setText(sunday.toString() + " °C");
    }

    public void setImgPath(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday){
        this.imgMo.setImage(new Image(new File(monday).toURI().toString()));
        this.imgDi.setImage(new Image(new File(tuesday).toURI().toString()));
        this.imgMi.setImage(new Image(new File(wednesday).toURI().toString()));
        this.imgDo.setImage(new Image(new File(thursday).toURI().toString()));
        this.imgFr.setImage(new Image(new File(friday).toURI().toString()));
        this.imgSa.setImage(new Image(new File(saturday).toURI().toString()));
        this.imgSo.setImage(new Image(new File(sunday).toURI().toString()));
    }

    public void setCityAndDate(String city, String date){
        /*
        Stadt und Datum setzen
         */
    }

    public void setState(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday){
        this.zustMo.setText(monday);
        this.zustDi.setText(tuesday);
        this.zustMi.setText(wednesday);
        this.zustDo.setText(thursday);
        this.zustFr.setText(friday);
        this.zustSa.setText(saturday);
        this.zustSo.setText(sunday);
    }

    public String getInput() {
        return this.txtField.getText();
    }
}

