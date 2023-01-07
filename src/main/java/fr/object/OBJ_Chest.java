package fr.object;

import fr.gompg.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject {
	public OBJ_Chest(GamePanel _gamePanel) {
		name = "chest";
		gamePanel = _gamePanel;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
			uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
