package Controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigLoader {
    private static ConfigLoader configLoader = null;
    public static ConfigLoader getInstance() {
        if(configLoader == null)
            configLoader = new ConfigLoader();
        return configLoader;
    }
    private String path;
    private File file;
    private FileInputStream inputStream;
//    private java.util.Properties properties;
    private PrintStream printStream;
    private Scanner scanner;
    private ConfigLoader(){
        path = "src/main/resources/config.txt";
        file = new File(path);
        try {
//            inputStream = new FileInputStream(file);
//            properties = new Properties();
//            properties.load(inputStream);
//            printStream = new PrintStream(file);
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void readConfig(){
        JSONObject object = new JSONObject(scanner.nextLine());
        JSONArray order = new JSONArray(scanner.nextLine());
        JSONArray images = new JSONArray(scanner.nextLine());
        ArrayList listImages = Properties.images;
        for(int i = 0; i < images.length(); i++){
            listImages.add((String) images.get(i));
        }
        ArrayList listOrders = Properties.orders;
//        for(int i = 0; i < order.length(); i++){
//            listOrders.add((Integer) order.get(i));
//        }
        for(int i = 0; i < order.length(); i++){
            int k = 0;
            for(int j = 0; j < order.length(); j++)
                if(order.getInt(j) == i){
                    k = j;
                    break;
                }
            listOrders.add(k);
        }
//        System.out.println(listOrders);
        Properties.height = (int) object.get("Height");
        Properties.width = (int) object.get("Width");

        object = new JSONObject(scanner.nextLine());
        boolean diameterChange = object.getBoolean("diameter");
        Properties.diameterChange = diameterChange;

        object = new JSONObject(scanner.nextLine());
        boolean graphic = object.getBoolean("graphic");
        Properties.graphic = graphic;

    }
}
