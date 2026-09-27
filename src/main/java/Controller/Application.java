package Controller;

import Model.CharacterModel.PuzzlePieceModel;
import View.CLI;
import View.CharacterView.PuzzlePieceView;
import View.Graphic;
import View.MyPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.regex.Pattern;


public class Application implements Runnable{
    private int n, m;
    public Board board;
    private Scanner sc;
    public CliKeyListener cliKeyListener;
    public Application() {
//        ConfigLoader.getInstance().readConfig();
//        init();

        init();


        run();
    }
    public void init(){
        board = Board.getInstance();
        board.init();

        n = Properties.width;
        m = Properties.height;

//        System.out.println(m + " " + n);
        if(Properties.graphic) {
            Graphic.getInstance().initGraphic();
            Graphic.getInstance().makeGraphic();
        }
        else {
            CLI.getInstance().initCli();
            CLI.getInstance().makeCli();
            sc = new Scanner(System.in);
            cliKeyListener = new CliKeyListener();
        }
    }
    public static void sendError(){
        // TODO : send error fo r cli & graphic
        JOptionPane.showMessageDialog(Graphic.getInstance().frame, "this puzzle is not solvable, change your config and try again", "Puzzle not solvable", JOptionPane.WARNING_MESSAGE);
    }
    @Override
    public void run(){
        while (true) {
            try {
                long frameRate = 500;
                if(Properties.graphic)
                    frameRate = Properties.frameRate;
                Thread.sleep(frameRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            paint();

            if (board.gameFinished) {
                break;
            }

            if (board.gameState.equals("finished")) {
                sendFinish();
                board.gameFinished = true;
            }
        }
        ArrayList<Integer> order;
        int n = Properties.width;
        int m = Properties.height;
        while (true){
            order = Board.generateRandom(n * m);
//            System.out.println(order);
            if(Application.solvable(Properties.missing, order)){
                Properties.orders = order;
                break;
            }
        }
//        Board.getInstance().makeNull();
//        Graphic.getInstance().makeNull();
//        Board.getInstance().makeNull();
        Board.getInstance().piecesRandomOrder = order;
        Board.getInstance().views = new ArrayList<>();
        Board.getInstance().models = new ArrayList<>();
        Board.getInstance().gameFinished = false;
        Board.getInstance().gameState = "#";
        Board.getInstance().piecesRandomOrder = order;
        Graphic.getInstance().makeGraphic();
        Board.getInstance().init();
        run();
    }
    public void sendFinish(){
        //TODO :
        if(Properties.graphic)
            JOptionPane.showMessageDialog(Graphic.getInstance().frame, "You finished the game, congratulation", "Game Finished", JOptionPane.INFORMATION_MESSAGE);
        else System.out.println("game finish");
    }
    public void paint(){
        //TODO :
        for(PuzzlePieceModel model : board.models) {
            PuzzlePieceView puzzle = null;
            for (PuzzlePieceView view : board.views) {
//                System.out.println(model.pieceNumber + " " + view.getPieceNumber());
                if(view.getPieceNumber() == model.pieceNumber)
                    puzzle = view;
            }
            if(puzzle == null){
                puzzle = new PuzzlePieceView(model.pieceNumber, model.location);
                board.views.add(puzzle);
            }
            puzzle.setLocation(model.location);
        }
        if(!Properties.graphic)paintCli();
        else paintGraphic();
    }
    public void paintCli(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(Board.getInstance().models.get(i * n + j).pieceNumber + " ");
            }
            System.out.println();
        }
        if(sc.hasNext()){
            String s = sc.next();
            cliKeyListener.pressed(s);
        }
    }
    public void paintGraphic(){
        Graphic.getInstance().panel.repaint();
        Graphic.getInstance().frame.repaint();

    }

    public static boolean solvable(int missingPiece, ArrayList<Integer> piecesOrder) {
        if(!Properties.diameterChange)
            return notDiameterSolvable(missingPiece, piecesOrder);
        return diameterSolvable(missingPiece, piecesOrder);
    }
    public static boolean diameterSolvable(int missingPiece, ArrayList<Integer> piecesOrder){
        //todo :
        return true;
    }
    public static boolean notDiameterSolvable(int missingPiece, ArrayList<Integer> piecesOrder){
        int inversionCount = 0;

        for (int i = 0; i < Properties.width * Properties.height; i++) {
            for (int j = i + 1; j < Properties.width * Properties.height; j++) {
                if (piecesOrder.get(i) > piecesOrder.get(j)) {
                    inversionCount += 1;
                }
            }
        }

        int n = Properties.width;
        int m = Properties.height;

        //TODO : change this

        int parity = inversionCount % 2;
        int distanceOfMissingPiece = (2 - (missingPiece % 3)) + (2 - (missingPiece / 3));

        parity ^= (distanceOfMissingPiece % 2);
        if (parity == 0) {
            return true;
        }
        return false;
    }
}