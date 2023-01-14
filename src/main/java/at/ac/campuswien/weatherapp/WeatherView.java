package at.ac.campuswien.weatherapp;

import javafx.fxml.FXML;
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
    protected void onHelloButtonClick(){
        //zustMo.setText("Cloudy");

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
        /*Image i = new Image(monday);
        String dir = System.getProperty("user.dir");

        //File f = new File("test.txt");
       // System.out.println(f.getAbsolutePath());
       // System.out.println(f.getPath());

        // directory from where the program was launched
        // e.g /home/mkyong/projects/core-java/java-io
        System.out.println(dir);
        this.imgMo.setImage(i);*/
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

