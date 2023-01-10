package fr.multi;

import fr.entity.Entity;
import fr.entity.Player;
import fr.gompg.GamePanel;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.ParseException;

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
    public Player[] updateServer(GamePanel gamePanel, String json, Player[] otherPlayer) throws IOException, ParseException {
        String response;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            HttpPost postRequest = new HttpPost("http://localhost:8080/update");
            StringEntity body = new StringEntity(json);
            postRequest.setEntity(body);
            response = EntityUtils.toString(httpClient.execute(postRequest).getEntity());
        }
        JsonParser jsonParser = new JsonParser();
        return jsonParser.getServerData(gamePanel, response);

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
