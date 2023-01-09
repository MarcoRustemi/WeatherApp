module at.ac.campuswien.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.ac.campuswien.weatherapp to javafx.fxml;
    exports at.ac.campuswien.weatherapp;
}