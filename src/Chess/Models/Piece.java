package Chess.Models;

import java.util.ArrayList;

public interface Piece {
    ArrayList<Move> move(ChessBoard board);
    void calculateScope(BoardSquare[][] board);
    boolean isWhite();
    char getDescription();
    void setSquare(BoardSquare square);
}
