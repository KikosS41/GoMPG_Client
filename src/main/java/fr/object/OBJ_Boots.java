package fr.object;

import fr.entity.Entity;
import fr.gompg.GamePanel;

public class OBJ_Boots extends Entity {
	
	GamePanel gamePanel;
	
	public OBJ_Boots(GamePanel gamePanel) {
		super(gamePanel);

		name = "Boots";
		down1 = setup("/objects/boots", gamePanel.tileSize, gamePanel.tileSize);
	}
}