package userInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by trongphuong1011 on 10/14/2017.
 */
public class GamePanel extends JPanel implements Runnable{
    private Thread thread;

    @Override
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(0,0,GameFrame.SCREEN_WIDTH,GameFrame.SCREEN_HEIGHT);
    }

    public void startGame(){
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Run game panel thread");
    }
}
