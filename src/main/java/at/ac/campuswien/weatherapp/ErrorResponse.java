package at.ac.campuswien.weatherapp;


public class ErrorResponse<U, V> {
    private U status;
    private V errorMessage;

    public ErrorResponse(U status, V errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public U getStatus() {
        return status;
    }

    public V getErrorMessage() {
        return errorMessage;
    }
}
