package fr.gompg;

import fr.entity.NPC_OldMan;
import fr.monster.MON_GreenSlime;
import fr.object.*;

public class AssetSetter {
GamePanel gamePanel;

	public AssetSetter(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	public void setObject() {
		gamePanel.obj[0] = new OBJ_Key(gamePanel);
		gamePanel.obj[0].worldX = 23 * gamePanel.tileSize;
		gamePanel.obj[0].worldY = 7 * gamePanel.tileSize;
		
		gamePanel.obj[1] = new OBJ_Door(gamePanel);
		gamePanel.obj[1].worldX = 10 * gamePanel.tileSize;
		gamePanel.obj[1].worldY = 12 * gamePanel.tileSize;
		
		gamePanel.obj[2] = new OBJ_Chest(gamePanel);
		gamePanel.obj[2].worldX = 10 * gamePanel.tileSize;
		gamePanel.obj[2].worldY = 8 * gamePanel.tileSize;
		
		gamePanel.obj[3] = new OBJ_Boots(gamePanel);
		gamePanel.obj[3].worldX = 37 * gamePanel.tileSize;
		gamePanel.obj[3].worldY = 42 * gamePanel.tileSize;
		
	}
	
	public void setNPC() {
		gamePanel.npc[0]= new NPC_OldMan(gamePanel);
		gamePanel.npc[0].worldX = gamePanel.tileSize*38;
		gamePanel.npc[0].worldY = gamePanel.tileSize*8;
	}
	
	public void setMonster() {
		gamePanel.monster[0]= new MON_GreenSlime(gamePanel);
		gamePanel.monster[0].worldX = gamePanel.tileSize*23;
		gamePanel.monster[0].worldY = gamePanel.tileSize*36f;
	}
}
