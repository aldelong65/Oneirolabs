package Chess.Models;

import java.util.ArrayList;

public class Knight implements Piece{
    private boolean colorIsWhite;
    private char description;
    private BoardSquare square;

    public Knight(boolean colorIsWhite, BoardSquare square) {
        this.colorIsWhite = colorIsWhite;
        description = colorIsWhite ? 'N' : 'n';
        this.square = square;
    }

    @Override
    public ArrayList<Move> move(ChessBoard board) {
        return new ArrayList<>();
    }

    @Override
    public void calculateScope(BoardSquare[][] board) {

    }

    @Override
    public boolean isWhite() {
        return colorIsWhite;
    }

    @Override
    public char getDescription() {
        return description;
    }

    @Override
    public void setSquare(BoardSquare square) {
        this.square = square;
    }
}
