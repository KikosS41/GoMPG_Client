package fr.object;

import fr.gompg.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject{
	public OBJ_Door(GamePanel _gamePanel) {
		name = "door";
		gamePanel = _gamePanel;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
			uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
