package at.ac.campuswien.ApiConnector;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ApiConnector {

    final String url = "https://api.weatherapi.com/v1/current.json";
    final String key = "265aa588f98045e7933132318231001";

    public ApiConnector(){
    }

    public boolean connect(HashMap<String, String> params) throws IOException {

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

        // Set request header
        //con.setRequestProperty("Content-Type", "application/json");

        //String contentType = con.getHeaderField("Content-Type");

        // con.setConnectTimeout(5000);
        // con.setReadTimeout(5000);


        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        con.disconnect();

        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }


        System.out.println("Content: " + content.toString() + "\nStatus: " + streamReader.toString());
        return true;
    }
}

//265aa588f98045e7933132318231001
