package fr.multi;

import fr.entity.OtherPlayer;
import fr.entity.Player;
import fr.gompg.GamePanel;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonParser {
    public String generatePlayerData(Player player){
        // creating JSONObject
        JSONObject jo = new JSONObject();

        // putting data to JSONObject
        jo.put("name", player.name);

        Map<String, java.io.Serializable> m = new LinkedHashMap<>(4);
        m.put("x", player.worldX);
        m.put("y", player.worldY);
        m.put("z", 1);

        jo.put("coordinate", m);
        jo.put("attack-damage", 25);
        jo.put("health", 75);
        return jo.toString();
    }

    public List<OtherPlayer> getServerData(GamePanel gamePanel, String inputData) throws ParseException {
        org.json.JSONObject jo = new org.json.JSONObject(inputData);
        org.json.JSONArray ja = jo.getJSONArray("players");
        List<OtherPlayer> allOtherPlayer = new ArrayList<OtherPlayer>();
        int i;
        for (i=0;i<ja.length();i++){
            jo = (org.json.JSONObject) ja.get(i);
            Object coordinate = new JSONParser().parse(jo.get("coordinate").toString());
            JSONObject coordinateJson = (JSONObject) coordinate;
            if (!jo.get("name").toString().equals(gamePanel.player.name)){
                allOtherPlayer.add(new OtherPlayer(gamePanel, jo.get("name").toString(), Integer.parseInt(coordinateJson.get("x").toString()),Integer.parseInt(coordinateJson.get("y").toString())));
            }
        }

        return allOtherPlayer;
    }
}
