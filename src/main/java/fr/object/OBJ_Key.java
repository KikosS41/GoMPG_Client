package fr.object;

import fr.entity.Entity;
import fr.gompg.GamePanel;

import java.awt.image.BufferedImage;

public class OBJ_Key extends Entity {

    public BufferedImage image;
    GamePanel gamePanel;
	
	public OBJ_Key(GamePanel gamePanel) {
		super(gamePanel);

		name = "Key";
		down1= setup("/objects/key", gamePanel.tileSize, gamePanel.tileSize);
	}
}
