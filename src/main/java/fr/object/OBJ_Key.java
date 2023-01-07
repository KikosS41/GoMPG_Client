package fr.object;

import fr.gompg.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {
	public OBJ_Key(GamePanel _gamePanel) {
		name = "key";
		gamePanel = _gamePanel;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

