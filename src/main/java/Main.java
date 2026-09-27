import Controller.Application;
import Controller.Board;
import Controller.ConfigLoader;
import Controller.Properties;
import View.CLI;
import View.Graphic;
import View.MyPanel;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ConfigLoader.getInstance().readConfig();
        run();
    }
    public static void run(){
        new Application();
    }
}
