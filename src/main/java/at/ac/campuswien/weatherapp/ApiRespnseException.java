package at.ac.campuswien.weatherapp;

public class ApiRespnseException extends Exception{
    public ApiRespnseException(String errorMessage){
        super(errorMessage);
    }
}
