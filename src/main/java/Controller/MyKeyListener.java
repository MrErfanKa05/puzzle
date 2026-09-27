package Controller;

import View.MyPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int n, m;
        m = Properties.width;
        n = Properties.height;

        int missingPieceIndex = Board.getInstance().missingPiece;
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT || keyEvent.getKeyCode() == KeyEvent.VK_D) {
            if (missingPieceIndex % m == m - 1) {
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + 1);
            Board.getInstance().setMissingPiece(missingPieceIndex + 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT || keyEvent.getKeyCode() == KeyEvent.VK_A) {
            if (missingPieceIndex % m == 0) {
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - 1);
            Board.getInstance().setMissingPiece(missingPieceIndex - 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP || keyEvent.getKeyCode() == KeyEvent.VK_W) {
            if (missingPieceIndex <= m - 1) {
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - m);
            Board.getInstance().setMissingPiece(missingPieceIndex - m);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN || keyEvent.getKeyCode() == KeyEvent.VK_S) {
            if (missingPieceIndex >= n * m - m) {
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + m);
            Board.getInstance().setMissingPiece(missingPieceIndex + m);
        }

        if (Board.getInstance().gameState.equals("finished")) {
            return;
        }

        if(!Properties.diameterChange)
            return;
        if(keyEvent.getKeyCode() == KeyEvent.VK_E){
            if(missingPieceIndex % m == m - 1 || missingPieceIndex / m == 0){
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - m + 1);
            Board.getInstance().setMissingPiece(missingPieceIndex - m + 1);
        } else if(keyEvent.getKeyCode() == KeyEvent.VK_C){
            if(missingPieceIndex % m == m - 1 || missingPieceIndex / m == n - 1){
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + m + 1);
            Board.getInstance().setMissingPiece(missingPieceIndex + m + 1);
        } else if(keyEvent.getKeyCode() == KeyEvent.VK_Q) {
            if(missingPieceIndex % m == 0 || missingPieceIndex / m == 0){
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - m - 1);
            Board.getInstance().setMissingPiece(missingPieceIndex - m - 1);
        } else if(keyEvent.getKeyCode() == KeyEvent.VK_Z){
            if(missingPieceIndex % m == 0 || missingPieceIndex / m == n - 1){
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + m - 1);
            Board.getInstance().setMissingPiece(missingPieceIndex + m - 1);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

