package Model.CharacterModel;

import Model.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PuzzlePieceModel {
    public int pieceNumber;
    public Location location;
    public PuzzlePieceModel(int pieceNumber){
        this.pieceNumber = pieceNumber;
    }
    public PuzzlePieceModel(int pieceNumber, Location location) {
        this(pieceNumber);
        this.location = location;
    }

    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public PuzzlePieceModel getClone() {
        PuzzlePieceModel clone = new PuzzlePieceModel(pieceNumber, location);

        return clone;
    }
}

