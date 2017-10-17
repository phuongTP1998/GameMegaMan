package userInterface;

import gameobject.MegaMan;

import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 10/15/2017.
 */
public class InputManager {

    private GamePanel gamePanel;

    public InputManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void processKeyPressed(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_UP:

                break;
            case KeyEvent.VK_DOWN:

                break;
            case KeyEvent.VK_LEFT:
                gamePanel.megaman.setSpeedX(-5);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.megaman.setSpeedX(5);
                break;
            case KeyEvent.VK_ENTER:

                break;
            case KeyEvent.VK_A:

                break;
        }
    }

    public void processKeyReleased(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_UP:

                break;
            case KeyEvent.VK_DOWN:

                break;
            case KeyEvent.VK_LEFT:
                gamePanel.megaman.setDirection(MegaMan.DIR_LEFT);
                gamePanel.megaman.setSpeedX(0);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.megaman.setDirection(MegaMan.DIR_RIGHT);
                gamePanel.megaman.setSpeedX(0);
                break;
            case KeyEvent.VK_ENTER:

                break;
            case KeyEvent.VK_A:

                break;
        }
    }
}
