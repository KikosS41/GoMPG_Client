package fr.gompg;

import fr.enums.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	GamePanel gamePanel;
	public boolean upPressed, downPressed, leftPressed, rightPressed, ePressed;

	public KeyHandler(GamePanel _gamePanel) {
		gamePanel = _gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (gamePanel.gameState) {
			case playState:

				if(keyCode == KeyEvent.VK_Z) {
					upPressed = true;
				}
				if(keyCode == KeyEvent.VK_S) {
					downPressed = true;
				}
				if(keyCode == KeyEvent.VK_Q) {
					leftPressed = true;
				}
				if(keyCode == KeyEvent.VK_D) {
					rightPressed = true;
				}

				if(keyCode == KeyEvent.VK_ESCAPE) {
					gamePanel.gameState = GameState.pauseState;
					gamePanel.stopMusic();
				}
				if(keyCode == KeyEvent.VK_E) {
					ePressed = true;
				}
				break;

			case pauseState:
				if(keyCode == KeyEvent.VK_ESCAPE) {
					gamePanel.gameState = GameState.playState;
					gamePanel.playMusic(0);
				}
				break;

			case dialogState:
				if(keyCode == KeyEvent.VK_E) {
					gamePanel.gameState = GameState.playState;
				}
				break;

			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if(keyCode == KeyEvent.VK_Z) {
			upPressed = false;
		}
		if(keyCode == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(keyCode == KeyEvent.VK_Q) {
			leftPressed = false;
		}
		if(keyCode == KeyEvent.VK_D) {
			rightPressed = false;
		}

	}

}