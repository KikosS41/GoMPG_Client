package fr.multi;

import fr.entity.Player;
import fr.gompg.GamePanel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    public Player[] getServerData(GamePanel gamePanel, String inputData) throws ParseException {
        Object obj = new JSONParser().parse(inputData);
        JSONObject jo = (JSONObject) obj;
        JSONArray ja = jo.getJSONArray("players");
        List<Player> otherPlayer = null;
        int i;
        for (i=0;i<ja.length();i++){
            obj = ja.get(i);
            jo = (JSONObject) obj;
            Object coordinate = new JSONParser().parse((String) jo.get("coordinate"));
            JSONObject coordinateJson = (JSONObject) coordinate;
            otherPlayer.add(new Player(gamePanel, (String) jo.get("name"), (Integer) coordinateJson.get("x"),(Integer) coordinateJson.get("y")));
        }

        Player[] players= otherPlayer.toArray(new Player[0]);
        return players;
    }
}
