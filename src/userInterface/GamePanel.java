package userInterface;

import effect.Animation;
import effect.CacheDataLoader;
import effect.FrameImage;
import gameobject.MegaMan;
import gameobject.PhysicalMap;
import jdk.internal.util.xml.impl.Input;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by trongphuong1011 on 10/14/2017.
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    private Thread thread;
    private boolean isRunning;
    private InputManager inputManager;

    private BufferedImage bufImage;
    private Graphics2D bufG2D;

    MegaMan megaman = new MegaMan(300,300,100,100,0.1f);
    PhysicalMap physicalMap = new PhysicalMap(0,0);

    public GamePanel() {
        inputManager = new InputManager(this);

        bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bufImage,0,0,this);
    }

    public void UpdateGame(){
        megaman.update();
    }

    public void RenderGame() {
        if (bufImage == null) {
            bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }
        if (bufImage != null) {
            bufG2D = (Graphics2D) bufImage.getGraphics();
        }
        if (bufG2D != null){
            bufG2D.setColor(Color.WHITE);
            bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);

            //draw game here
//            megaman.draw(bufG2D);
            physicalMap.draw(bufG2D);
        }
    }

    public void startGame() {
        if (thread == null) {
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        long FPS = 80;
        // period là chu kì, 1000 ở đây là tính theo milisecond, 1000000 là tính theo nanosecond, 1 mili = 1 triệu nano
        long period = 1000 * 1000000 / FPS;
        long beginTime;
        long sleepTime;
        beginTime = System.nanoTime();
        while (isRunning) {
            //Update
            //Render
            UpdateGame();
            RenderGame();
            repaint();

            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;

            try {
                if (sleepTime > 0)
                    Thread.sleep(sleepTime / 1000000);
                else Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beginTime = System.nanoTime();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputManager.processKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputManager.processKeyReleased(e.getKeyCode());
    }
}
