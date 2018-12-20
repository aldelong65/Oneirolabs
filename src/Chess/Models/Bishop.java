package Chess.Models;

import Chess.Util.BoardUtil;
import Chess.Util.Constants;

import java.util.ArrayList;

public class Bishop implements Piece {
    private boolean colorIsWhite;
    private char description;
    private char[][] scope = new char[8][8];
    private BoardSquare square;

    public Bishop(boolean colorIsWhite, BoardSquare square) {
        this.colorIsWhite = colorIsWhite;
        description = colorIsWhite ? 'B' : 'b';
        this.square = square;
    }

    @Override
    public ArrayList<Move> move(ChessBoard board) {
        ArrayList<Move> moveList = new ArrayList<>();
        calculateScope(board.getBoard());
        return moveList;
    }

    @Override
    public void calculateScope(BoardSquare[][] board) {
        int sourceFile = Constants.FILE_LIST.indexOf(square.getFile());
        int sourceRank = Constants.RANK_LIST.get(square.getRank());
        scope = BoardUtil.buildCharBoard(board);
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
