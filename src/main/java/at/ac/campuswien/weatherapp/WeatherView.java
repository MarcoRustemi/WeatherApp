package at.ac.campuswien.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.File;


public class WeatherView {
    @FXML
    private Label zustMo, zustDi, zustMi, zustDo,zustFr,zustSa,zustSo; //fx:ids conditions (cloudy,rainy,sunny)Mo-So
    @FXML
    private Label tempMo, tempDi, tempMi,tempDo, tempFr,tempSa,tempSo; //fx:ids temp Mo-So
    @FXML
    private ImageView imgMo,imgDi,imgMi,imgDo,imgFr,imgSa,imgSo;// fx:ids icons Mo-So
    @FXML
    private TextField txtField;
    @FXML
    private Button searchButton;
    @FXML
    private Label city;
    @FXML
    private Label date;
    @FXML
    private Label errorMessage;
    @FXML
    private BorderPane moBackground, tueBackground, wedBackground, thuBackground, friBackground, satBackground, sunBackground;

    public Button getSearchButton(){
        return searchButton;
    }

    public void setTemp(Double monday, Double tuesday, Double wednesday, Double thursday, Double friday, Double saturday, Double sunday){
        this.errorMessage.setVisible(false);
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
        this.city.setText(city);
        this.date.setText(date);
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

    public void setErrorMessage(String e){
        this.errorMessage.setText(e);
        this.errorMessage.setVisible(true);
    }

    public void setCurrDay(int day){
        switch (day){
            case 1:
                this.moBackground.getStyleClass().setAll("current-day");
                break;
            case 2:
                this.tueBackground.getStyleClass().setAll("current-day");
                break;
            case 3:
                this.wedBackground.getStyleClass().setAll("current-day");
                break;
            case 4:
                this.thuBackground.getStyleClass().setAll("current-day");
                break;
            case 5:
                this.friBackground.getStyleClass().setAll("current-day");
                break;
            case 6:
                this.satBackground.getStyleClass().setAll("current-day");
                break;
            case 7:
                this.sunBackground.getStyleClass().setAll("current-day");
                break;
        }
    }
}

