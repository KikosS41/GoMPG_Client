package fr.multi;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;


public class Multi {
    public void connect(String json) throws IOException {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            HttpPost postRequest = new HttpPost("http://localhost:8080/connect");
            StringEntity body = new StringEntity(json);
            postRequest.setEntity(body);
            CloseableHttpResponse response = httpClient.execute(postRequest);

        }
    }
    public void updateServer(String json) throws IOException {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            HttpPost postRequest = new HttpPost("http://localhost:8080/update");
            StringEntity body = new StringEntity(json);
            postRequest.setEntity(body);
            CloseableHttpResponse response = httpClient.execute(postRequest);

        }
    }
    public void disconnect(String json) throws IOException {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            HttpPost postRequest = new HttpPost("http://localhost:8080/disconnect");
            StringEntity body = new StringEntity(json);
            postRequest.setEntity(body);
            CloseableHttpResponse response = httpClient.execute(postRequest);

        }
    }
}
