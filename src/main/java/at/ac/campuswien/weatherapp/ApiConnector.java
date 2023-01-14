package at.ac.campuswien.weatherapp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ApiConnector {

    final String url = "https://api.weatherapi.com/v1/forecast.json";

    public ApiConnector(){
    }

    public ApiResponse<Boolean, JSONArray> connect(HashMap<String, String> params) throws IOException {

        // Create a HttpURLConnection instance; NOTE: Connection is not established yet
        URL url = new URL(this.url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        // Map with the request parameters
        Map<String, String> parameters = new HashMap<>();
        parameters.putAll(params);
        // Set the doOutput property and write the String into the OutputStream
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters)); // ParameterStringBuilder gives the right format
        out.flush();
        out.close();

        // con.setConnectTimeout(5000);
        // con.setReadTimeout(5000);

        int status = con.getResponseCode();

        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
            return new ApiResponse<>(Boolean.FALSE, null);
        } else {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String o = in.readLine();
            in.close();
            JSONParser parser = new JSONParser();
            JSONObject content;
            JSONObject content2;
            JSONArray content3;
            try {
                content = (JSONObject) parser.parse(o);
                content2 = (JSONObject) content.get("forecast");
                content3 = (JSONArray) content2.get("forecastday");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            con.disconnect();
            //System.out.println("Content: " + content3.get(2).toString());

            return new ApiResponse<>(Boolean.TRUE, content3);
        }

    }
}

//265aa588f98045e7933132318231001
