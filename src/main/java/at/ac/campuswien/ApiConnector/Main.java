import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        ApiConnector connector = new ApiConnector();
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "265aa588f98045e7933132318231001");
        map.put("q", "Paris");
        try {
            connector.connect(map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}