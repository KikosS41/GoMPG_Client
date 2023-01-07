package fr.object;

import fr.gompg.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject{
	public OBJ_Boots(GamePanel _gamePanel) {
		name = "boots";
		gamePanel = _gamePanel;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
			uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}