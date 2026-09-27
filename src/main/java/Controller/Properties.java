package Controller;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Properties {
    public static int width, height;
    public static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static int maxSize = Math.max(screenWidth, screenHeight) / 3;
    public static int LocationX = screenWidth / 2;
    public static int LocationY = screenHeight / 2;
    public static int fps = 60;
    public static long frameRate = TimeUnit.SECONDS.toMillis(1) / fps;
    public static ArrayList<String> images = new ArrayList<>();
    public static ArrayList<Integer> orders = new ArrayList<>();
    public static boolean diameterChange;
    public static boolean graphic;
    public static int missing = 0;
}
