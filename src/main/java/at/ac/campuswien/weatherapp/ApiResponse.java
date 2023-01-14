package at.ac.campuswien.weatherapp;

public class ApiResponse<U, V> {
    private U status;
    private V json;

    public ApiResponse(U status, V json) {
        this.status = status;
        this.json = json;
    }

    public U getStatus() {
        return status;
    }

    public V getJson() {
        return json;
    }
}

