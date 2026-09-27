package View;

import Controller.Board;
import Controller.MyKeyListener;
import Controller.Properties;
import Model.CharacterModel.PuzzlePieceModel;
import Model.Location;

import javax.swing.*;

public class Graphic {
    public JFrame frame;
    public MyPanel panel;
    private Board board;
    private int n, m;
    private Graphic(){
        frame = new JFrame();
        panel = MyPanel.getInstance();
        n = Properties.width;
        m = Properties.height;
        board = Board.getInstance();

    }
    private static Graphic graphic;

    public static Graphic getInstance() {
        if(graphic == null)
            graphic = new Graphic();
        return graphic;
    }
    public void makeNull(){
        graphic = null;
    }
    public void makeGraphic(){
        for (int i = 0; i < n * m; i++) {
//            System.out.println(i + " " + board.piecesRandomOrder.get(i));
            int k = board.piecesRandomOrder.get(i);
            //todo : board missing piece
//            if (board.missingPiece != k) {
                board.models.add(new PuzzlePieceModel(k, new Location(panel.getWidth() / n * (i % n), panel.getHeight() / m * (i / n))));
//            } else {
//                board.models.add(new PuzzlePieceModel(0, new Location(panel.getHeight() / m * (i % m), panel.getWidth() / n * (i / n))));
//            }
        }
    }
    public void initGraphic(){
        int screenWidth = Properties.screenWidth;
        int screenHeight = Properties.screenHeight;
        int maxSize = Properties.maxSize;
//        int
        panel.setSize(maxSize/3 * n, maxSize/3 * m);
        panel.setLocation(Properties.LocationX - maxSize/3 * n / 2, Properties.LocationY - maxSize/3 * m / 2);
        frame.setSize(panel.getSize());
        frame.setLocation(panel.getLocation());
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.addKeyListener(new MyKeyListener());
        frame.setVisible(true);
    }
}
