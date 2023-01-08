package fr.multi;

import fr.entity.Player;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonParser {
    public String getPlayerData(Player player){
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
        String result = jo.toString();
        return result;
    }
}
