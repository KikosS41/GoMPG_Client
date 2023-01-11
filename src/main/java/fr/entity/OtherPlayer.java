package fr.entity;

import fr.enums.Direction;
import fr.gompg.GamePanel;

import java.awt.*;

public class OtherPlayer extends Entity{
    public final String name;

    public OtherPlayer(GamePanel gamePanel, String name, int worldX, int worldY) {
        super(gamePanel);
        this.name = name;
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = Direction.DOWN;

        //solidArea = new Rectangle(8, 12, 28, 28);
        //solidAreaDefaultX = solidArea.x;
        //solidAreaDefaultY = solidArea.y;

        getPlayerImage();
    }
    public void getPlayerImage() {
        up1 = setup("/player/boy_up_1");
        up2 = setup("/player/boy_up_2");
        down1 = setup("/player/boy_down_1");
        down2 = setup("/player/boy_down_2");
        right1 = setup("/player/boy_right_1");
        right2 = setup("/player/boy_right_2");
        left1 = setup("/player/boy_left_1");
        left2 = setup("/player/boy_left_2");
    }
}
