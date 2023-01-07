package fr.object;

import fr.entity.Entity;
import fr.gompg.GamePanel;

public class OBJ_Chest extends Entity {
	
	GamePanel gamePanel;
	public OBJ_Chest(GamePanel gamePanel) {
		super(gamePanel);
		
		name = "Chest";
		down1 = setup("/objects/chest", gamePanel.tileSize, gamePanel.tileSize);
	}
}
