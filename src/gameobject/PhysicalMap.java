package gameobject;

import effect.CacheDataLoader;

import java.awt.*;

/**
 * Created by trongphuong1011 on 10/18/2017.
 */
public class PhysicalMap {
    public int[][] phys_map;
    private int titleSize;

    public float x, y;

    public PhysicalMap(float x, float y) {
        this.x = x;
        this.y = y;
        this.titleSize = 30;
        phys_map = CacheDataLoader.getInstance().getPhysicalMap();
    }

    public int getTitleSize() {
        return titleSize;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.GRAY);
        for (int i = 0; i < phys_map.length; i++) {
            for (int j = 0; j < phys_map[0].length; j++) {
                if (phys_map[i][j] != 0) {
                    g2.fillRect((int) x + j * titleSize, (int) y + i * titleSize, titleSize, titleSize);
                }
            }
        }
    }
}
