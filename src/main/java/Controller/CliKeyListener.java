package Controller;

public class CliKeyListener {
    public void pressed(String s){
        int n = Properties.height, m = Properties.width;
        int missingPieceIndex = Board.getInstance().missingPiece;
        if(s.equals("d")) {
            if (missingPieceIndex % m == m - 1) {
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + 1);
            Board.getInstance().setMissingPiece(missingPieceIndex + 1);
        }
        if(s.equals("a")) {
            if (missingPieceIndex % m == 0) {
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - 1);
            Board.getInstance().setMissingPiece(missingPieceIndex - 1);
        }
        if(s.equals("w")) {
            if (missingPieceIndex <= m - 1) {
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - m);
            Board.getInstance().setMissingPiece(missingPieceIndex - m);
        }
        if(s.equals("s")) {
            if (missingPieceIndex >= n * m - m) {
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + m);
            Board.getInstance().setMissingPiece(missingPieceIndex + m);
        }
        if(Properties.diameterChange == false){
            return;
        }
        if(s.equals("e")) {
            if(missingPieceIndex % m == m - 1 || missingPieceIndex / m == 0){
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - m + 1);
            Board.getInstance().setMissingPiece(missingPieceIndex - m + 1);
        }
        if(s.equals("q")) {
            if(missingPieceIndex % m == 0 || missingPieceIndex / m == 0){
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - m - 1);
            Board.getInstance().setMissingPiece(missingPieceIndex - m - 1);
        }
        if(s.equals("z")) {
            if(missingPieceIndex % m == 0 || missingPieceIndex / m == n - 1){
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + m - 1);
            Board.getInstance().setMissingPiece(missingPieceIndex + m - 1);
        }
        if(s.equals("c")) {
            if(missingPieceIndex % m == m - 1 || missingPieceIndex / m == n - 1){
                return;
            }
            Board.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + m + 1);
            Board.getInstance().setMissingPiece(missingPieceIndex + m + 1);
        }
    }
}
