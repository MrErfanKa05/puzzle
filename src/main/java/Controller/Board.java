package Controller;

import Model.CharacterModel.PuzzlePieceModel;
import Model.Location;
import View.CharacterView.PuzzlePieceView;
import View.Graphic;
import View.MyPanel;

import javax.swing.*;
import java.util.ArrayList;

public class Board {
    private static Board board = null;
    public int missingPiece = 0;
    public String gameState = "#";
    private int n, m;

    public static Board getInstance() {
        if(board == null) board = new Board();
        return board;
    }

    public ArrayList<PuzzlePieceModel> models;
    public ArrayList<Integer> piecesRandomOrder;
    public ArrayList<PuzzlePieceView> views;
    public boolean gameFinished = false;
    private Board(){
        piecesRandomOrder = Properties.orders;
        models = new ArrayList<>();
        views = new ArrayList<>();
        n = Properties.width;
        m = Properties.height;
        missingPiece = Properties.missing;
    }
    public void makeNull(){
        board = null;
    }
    public void init(){
        for (int i = 0; i < piecesRandomOrder.size(); i++)
            if (piecesRandomOrder.get(i) == Properties.missing)
                setMissingPiece(i);

        if (!Application.solvable(missingPiece, piecesRandomOrder)) {
            Application.sendError();
            gameFinished = true;
        }
    }
    private static int getNum(ArrayList<Integer> v)
    {
        int n = v.size();
        int index = (int)(Math.random() * n);
        int num = v.get(index);
        v.set(index, v.get(n - 1));
        v.remove(n - 1);
        return num;
    }
    public static ArrayList<Integer> generateRandom(int n)
    {
        ArrayList<Integer> v = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            v.add(i);
        ArrayList<Integer> order = new ArrayList<>();
        while (v.size() > 0)
        {
            order.add(getNum(v));
        }
        return order;
    }

    public void swapPieces(int i, int j) {
        PuzzlePieceModel copy = this.models.get(i).getClone();
        models.get(i).setPieceNumber(models.get(j).pieceNumber);
        models.get(j).setPieceNumber(copy.pieceNumber);

        if (gameFinished()) {
            gameState = "finished";
        }
    }

    public boolean gameFinished() {
        for (int i = 0; i < n * m; i++) {
            int pieceIdentifier = models.get(i).pieceNumber;
            if (pieceIdentifier == Properties.missing) {
                continue;
            }

            if (pieceIdentifier != i + 1) {
                return false;
            }
        }
        return true;
    }

    public void setMissingPiece(int missingPiece) {
        this.missingPiece = missingPiece;
    }

}
