package gameobject;

import userInterface.GameFrame;

import java.awt.*;

/**
 * Created by trongphuong1011 on 10/19/2017.
 */
public class GameWorld {
    public Megaman megaman;
    PhysicalMap physicalMap;

    Camera camera;

    public GameWorld() {
        megaman = new Megaman(300, 300, this);
        physicalMap = new PhysicalMap(0, 0, this);
        camera = new Camera(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, this);
    }

    public void Update() {
        megaman.Update();
        camera.Update();
    }

    public void Render(Graphics2D g2) {
        physicalMap.draw(g2);
        megaman.draw(g2);
    }
}
