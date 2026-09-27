package View.CharacterView;

import Controller.Properties;
import Model.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PuzzlePieceView {
    public static ArrayList<PuzzlePieceView> pieceViews = new ArrayList<>();
    public Image img;
    public int pieceNumber;
    public Location location;
    public PuzzlePieceView(int pieceNumber) {
        this.pieceNumber = pieceNumber;
        pieceViews.add(this);
//        if (pieceNumber != 0) {
//            try {
//                img = ImageIO.read(new File("src/main/resources/assets/" + pieceNumber + ".png"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            try {
//                img = ImageIO.read(new File("src/main/resources/assets/" + "missing.jpg"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        try {
            img = ImageIO.read(new File("src/main/resources/assets/" + Properties.images.get(pieceNumber)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PuzzlePieceView(int pieceNumber, Location location) {
        this(pieceNumber);
        this.location = location;
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setImage(Image img) {
        this.img = img;
    }

    public PuzzlePieceView(Image img, Location location, int pieceIdentifier) {
        this.img = img;
        this.location = location;
        this.pieceNumber = pieceIdentifier;
    }

    public PuzzlePieceView getClone(){
        PuzzlePieceView clone = new PuzzlePieceView(img, location, pieceNumber);

        return clone;
    }
}

