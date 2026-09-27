package View;

import Controller.Board;
import Controller.Properties;
import View.CharacterView.PuzzlePieceView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class MyPanel extends JPanel {
    public static MyPanel panelInstance;
    public Board board = Board.getInstance();
    private int n, m;
    public MyPanel() {
        n = Properties.width;
        m = Properties.height;
    }

    public static MyPanel getInstance() {
        if (panelInstance == null) {
            panelInstance = new MyPanel();
            return panelInstance;
        }
        return panelInstance;
    }
    public void makeNull(){
        panelInstance = null;
    }
    public void sendError(){
        JOptionPane.showMessageDialog(Graphic.getInstance().frame, "You finished the game, congratulation", "Game Finished", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PuzzlePieceView piece : board.views) {
            g.drawImage(piece.img, piece.location.x, piece.location.y, (int) this.getSize().getHeight() / m, (int) this.getSize().getWidth() / n, null);
        }
    }
}

