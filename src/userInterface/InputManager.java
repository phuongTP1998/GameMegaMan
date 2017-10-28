package userInterface;

import gameobject.GameWorld;
import gameobject.Megaman;

import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 10/15/2017.
 */
public class InputManager {
    private GameWorld gameWorld;

    public InputManager(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    public void processKeyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:

                break;
            case KeyEvent.VK_DOWN:

                break;
            case KeyEvent.VK_LEFT:
                gameWorld.megaman.setSpeedX(-5);
                break;
            case KeyEvent.VK_RIGHT:
                gameWorld.megaman.setSpeedX(5);
                break;
            case KeyEvent.VK_SPACE:
                gameWorld.megaman.jump();
                break;
            case KeyEvent.VK_A:

                break;
        }
    }

    public void processKeyReleased(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:

                break;
            case KeyEvent.VK_DOWN:

                break;
            case KeyEvent.VK_LEFT:
                gameWorld.megaman.setDirection(gameWorld.megaman.LEFT_DIR);
                gameWorld.megaman.setSpeedX(0);
                break;
            case KeyEvent.VK_RIGHT:
                gameWorld.megaman.setDirection(gameWorld.megaman.RIGHT_DIR);
                gameWorld.megaman.setSpeedX(0);
                break;
            case KeyEvent.VK_SPACE:

                break;
            case KeyEvent.VK_A:

                break;
        }
    }
}
