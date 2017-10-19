package effect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by trongphuong1011 on 10/15/2017.
 */
public class CacheDataLoader {
    private static CacheDataLoader instance;

    private String framefile = "data/frame.txt";
    private String animationfile = "data/animation.txt";
    private String physmapfile = "data/phys_map.txt";

    private Hashtable<String, FrameImage> frameImages;
    private Hashtable<String, Animation> animations;

    private int[][] phys_map;
    private int[][] background_map;

    private CacheDataLoader() {
    }

    public static CacheDataLoader getInstance() {
        if (instance == null) {
            instance = new CacheDataLoader();
        }
        return instance;
    }

    public void LoadData() throws IOException {
        LoadFrame();
        LoadAnimation();
        LoadPhysMap();
    }

    public void LoadFrame() throws IOException {
        frameImages = new Hashtable<>();

        FileReader fr = new FileReader(framefile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        if (br.readLine() == null) {
            System.out.println("No Data");
            throw new IOException();
        } else {
            fr = new FileReader(framefile);
            br = new BufferedReader(fr);
            while ((line = br.readLine()).equals("")) ;

            int n = Integer.parseInt(line);

            for (int i = 0; i < n; i++) {
                FrameImage frame = new FrameImage();
                while ((line = br.readLine()).equals("")) ;
                frame.setName(line);

                while ((line = br.readLine()).equals("")) ;
                String[] str = line.split(" ");
                String path = str[1];

                while ((line = br.readLine()).equals("")) ;
                str = line.split(" ");
                int x = Integer.parseInt(str[1]);

                while ((line = br.readLine()).equals("")) ;
                str = line.split(" ");
                int y = Integer.parseInt(str[1]);

                while ((line = br.readLine()).equals("")) ;
                str = line.split(" ");
                int w = Integer.parseInt(str[1]);

                while ((line = br.readLine()).equals("")) ;
                str = line.split(" ");
                int h = Integer.parseInt(str[1]);

                BufferedImage imageData = ImageIO.read(new File(path));
                BufferedImage image = imageData.getSubimage(x, y, w, h);
                frame.setImage(image);

                instance.frameImages.put(frame.getName(), frame);
            }
        }
        br.close();
    }

    public FrameImage getFrameImage(String name) {
        FrameImage frameImage = new FrameImage(instance.frameImages.get(name));
        return frameImage;
    }

    public Animation getAnimation(String name) {
        Animation animation = new Animation(instance.animations.get(name));
        return animation;
    }

    public int[][] getPhysicalMap() {
        return instance.phys_map;
    }

    public void LoadPhysMap() throws IOException {
        FileReader fr = new FileReader(physmapfile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        line = br.readLine();
        int numberOfRows = Integer.parseInt(line);
        line = br.readLine();
        int numberOfColumns = Integer.parseInt(line);

        instance.phys_map = new int[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            line = br.readLine();
            String [] str = line.split(" ");
            for(int j =0;j<numberOfColumns;j++){
                instance.phys_map[i][j] = Integer.parseInt(str[j]);
            }
        }
        br.close();
    }

    public void LoadAnimation() throws IOException {
        animations = new Hashtable<>();
        FileReader fr = new FileReader(animationfile);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        if (br.readLine() == null) {
            System.out.println("No data");
            throw new IOException();
        } else {
            fr = new FileReader(animationfile);
            br = new BufferedReader(fr);

            while ((line = br.readLine()).equals("")) ;
            int n = Integer.parseInt(line);

            for (int i = 0; i < n; i++) {
                Animation animation = new Animation();

                while ((line = br.readLine()).equals("")) ;
                animation.setName(line);

                while ((line = br.readLine()).equals("")) ;
                String[] str = line.split(" ");

                for (int j = 0; j < str.length; j += 2) {
                    animation.add(getFrameImage(str[j]), Double.parseDouble(str[j + 1]));
                }
                instance.animations.put(animation.getName(), animation);
            }
        }
    }
}
