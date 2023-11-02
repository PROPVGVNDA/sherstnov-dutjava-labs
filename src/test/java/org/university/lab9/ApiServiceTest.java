package org.university.lab9;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ApiServiceTest {

    @Test
    public void testProcessResponse() throws Exception {
        HttpURLConnection mockConnection = Mockito.mock(HttpURLConnection.class);
        String mockResponse = "Mocked response";
        InputStream mockInputStream = new ByteArrayInputStream(mockResponse.getBytes());

        when(mockConnection.getInputStream()).thenReturn(mockInputStream);

        String response = ApiService.processResponse(mockConnection);

        verify(mockConnection).disconnect();

        assertEquals(mockResponse, response);
    }

    @Test
    public void testProcessResponseWithException() throws Exception {
        HttpURLConnection mockConnection = Mockito.mock(HttpURLConnection.class);
        when(mockConnection.getInputStream()).thenThrow(new IOException("Mocked IOException"));

        try {
            ApiService.processResponse(mockConnection);
        } catch (Exception e) {
            assertEquals("Mocked IOException", e.getMessage());
            verify(mockConnection).disconnect();
        }
    }

    @Test
    public void testSetupConnection() throws Exception {
        HttpURLConnection mockConnection = Mockito.mock(HttpURLConnection.class);

        URL mockUrl = Mockito.mock(URL.class);
        when(mockUrl.openConnection()).thenReturn(mockConnection);

        HttpURLConnection returnedConnection = ApiService.setupConnection(mockUrl);

        verify(mockConnection).setRequestMethod("GET");
        verify(mockConnection).setRequestProperty("Content-Type", "application/json");
        verify(mockConnection).setRequestProperty("Accept", "application/json");

        assertNotNull(returnedConnection);
    }

    @Test
    public void testConstructUrlWithoutArguments() throws Exception {
        String path = "/testEndpoint";
        String arguments = "";
        URL url = ApiService.constructUrl(path, arguments);
        assertEquals("http://api.recrm.ru/json/testEndpoint?key=43a0cef4dd3b4c818a5328154582ef5d", url.toString());
    }

    @Test
    public void testConstructUrlWithArguments() throws Exception {
        String path = "/testEndpoint";
        String arguments = "param1=value1&param2=value2";
        URL url = ApiService.constructUrl(path, arguments);
        assertEquals("http://api.recrm.ru/json/testEndpoint?key=43a0cef4dd3b4c818a5328154582ef5d&param1=value1&param2=value2", url.toString());
    }

    @Test
    public void testConstructUrlEmptyPath() throws Exception {
        String path = "";
        String arguments = "param1=value1";
        URL url = ApiService.constructUrl(path, arguments);
        assertEquals("http://api.recrm.ru/json?key=43a0cef4dd3b4c818a5328154582ef5d&param1=value1", url.toString());
    }
}
