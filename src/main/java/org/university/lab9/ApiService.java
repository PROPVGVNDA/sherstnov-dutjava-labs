package org.university.lab9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    private static final String API_KEY = "43a0cef4dd3b4c818a5328154582ef5d";
    private static final String ENDPOINT = "http://api.recrm.ru/json";

    public static String callApi(String path, String arguments) throws Exception {
        URL url = constructUrl(path, arguments);
        HttpURLConnection connection = setupConnection(url);

        if (connection.getResponseCode() != 200) {
            throw new Exception("Failed: HTTP error code: " + connection.getResponseCode() + " " + connection.getResponseMessage());
        }

        return processResponse(connection);
    }

    protected static URL constructUrl(String path, String arguments) throws Exception {
        String sUrl = ENDPOINT + path + "?key=" + API_KEY;

        if (!arguments.isEmpty()) {
            sUrl += "&" + arguments;
        }

        return new URL(sUrl);
    }

    static HttpURLConnection setupConnection(URL url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    }

    static String processResponse(HttpURLConnection connection) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                output.append(line);
            }

            return output.toString();
        } finally {
            connection.disconnect();
        }
    }
}
