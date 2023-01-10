package fr.gompg;

import fr.multi.JsonParser;
import fr.multi.Multi;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GamePanel gamePanel = new GamePanel();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                try {
                    close(gamePanel);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        window.setResizable(false);
        window.setTitle("My game");

        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }

    public static void close(GamePanel gamePanel) throws IOException {
        Multi multi= new Multi();
        JsonParser jsonParser = new JsonParser();
        multi.disconnect(jsonParser.generatePlayerData(gamePanel.player));
    }
}