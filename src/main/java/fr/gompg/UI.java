package fr.gompg;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class UI {
	GamePanel gamePanel;
	Graphics2D graph2D;
	Font arial_40, arial_20;
	public boolean messageOn = false;
	String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public String currentDialog = "";

	public UI(GamePanel _gamePanel) {
		gamePanel = _gamePanel;
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_20 =  new Font("Arial", Font.BOLD, 20);
	}

	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}

	public void draw(Graphics2D _graph2D) {
		graph2D = _graph2D;
		graph2D.setFont(arial_40);
		graph2D.setColor(Color.white);

		switch (gamePanel.gameState) {
			case playState:

				break;
			case pauseState:
				drawPauseScreen();
				break;
			case dialogState:
				drawDialogScreen();
				break;
			default:
				break;
		}
	}

	public void drawPauseScreen() {
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		int y = gamePanel.screenHeight/2 - 10;

		graph2D.drawString(text, x, y);
	}

	public void drawDialogScreen() {
		// WINDOW
		int x = gamePanel.tileSize*2;
		int y = gamePanel.tileSize/2;
		int width = gamePanel.screenWidth - gamePanel.tileSize*4;
		int height = gamePanel.tileSize*4;

		drawSubWindow(x, y, width, height);

		x += gamePanel.tileSize;
		y += gamePanel.tileSize;
		graph2D.setFont(graph2D.getFont().deriveFont(Font.PLAIN, 28F));

		for (String line : currentDialog.split("\n")) {
			graph2D.drawString(line, x, y);
			y += 40;
		}

	}

	public void drawSubWindow(int x, int y, int width, int height) {
		Color color = new Color(0,0,0,200);
		graph2D.setColor(color);
		graph2D.fillRoundRect(x, y, width, height, 35, 35);

		color = new Color(255,255,255);
		graph2D.setColor(color);
		graph2D.setStroke(new BasicStroke(5));
		graph2D.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
	}

	public int getXforCenteredText(String text) {
		int lenght = (int)graph2D.getFontMetrics().getStringBounds(text, graph2D).getWidth();
		return gamePanel.screenWidth/2 - lenght/2;
	}
}
