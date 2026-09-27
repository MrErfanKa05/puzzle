package View;

import Controller.Board;
import Controller.Properties;
import Model.CharacterModel.PuzzlePieceModel;
import Model.Location;

public class CLI {
    private Board board;
    private int n, m;
    private static CLI cli;

    public static CLI getInstance() {
        if(cli == null)
            cli = new CLI();
        return cli;
    }

    private CLI(){
        n = Properties.width;
        m = Properties.height;
        board = Board.getInstance();
    }
    public void makeCli() {
        for (int i = 0; i < n * m; i++) {
//            System.out.println(i + " " + board.piecesRandomOrder.get(i));
            int k = board.piecesRandomOrder.get(i);
            //todo : board missing piece
            board.models.add(new PuzzlePieceModel(k, new Location((i % n), (i / n))));
        }
    }
    public void makeNull(){
        cli = null;
    }
    public void initCli() {

    }
}
