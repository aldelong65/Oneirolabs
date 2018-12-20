package Chess.Models;

import Chess.Util.BoardUtil;
import Chess.Util.Constants;

import java.util.ArrayList;

public class Pawn implements Piece {
    private boolean colorIsWhite;
    private boolean onOrigin;
    private int direction;
    private char description;
    private char[][] scope = new char[8][8];
    private BoardSquare square;

    public Pawn(boolean colorIsWhite, BoardSquare square) {
        this.colorIsWhite = colorIsWhite;
        onOrigin = true;
        direction = colorIsWhite ? -1 : 1;
        description = colorIsWhite ? 'P' : 'p';
        this.square = square;
    }

    @Override
    public ArrayList<Move> move(ChessBoard board) {
        ArrayList<Move> moveList = new ArrayList<>();
        calculateScope(board.getBoard());
        for(int rank = 0; rank < 8; rank++) {
            for(int file = 0; file < 8; file++) {
                if(scope[rank][file] == '+') {
                    moveList.add(new Move(square, board.getBoard()[rank][file], false));
                } else if(scope[rank][file] == 'x') {
                    moveList.add(new Move(square, board.getBoard()[rank][file], true));
                }
            }
        }
        return moveList;
    }

    @Override
    public void calculateScope(BoardSquare[][] board) {
        int sourceFile = Constants.FILE_LIST.indexOf(square.getFile());
        int sourceRank = Constants.RANK_LIST.get(square.getRank());
        boolean aEdge = square.getFile() == 'a';
        boolean hEdge = square.getFile() == 'h';
        scope = BoardUtil.buildCharBoard(board);

        if(board[sourceRank + direction][sourceFile].getPiece() == null) {
            scope[sourceRank + direction][sourceFile] = '+';
            if(onOrigin && board[sourceRank + (2 * direction)][sourceFile].getPiece() == null) {
                scope[sourceRank + (2 * direction)][sourceFile] = '+';
            }
        }
        if(!aEdge) {
            Piece checkSquareForPiece = board[sourceRank + direction][sourceFile - 1].getPiece();
            if(checkSquareForPiece  != null && checkSquareForPiece.isWhite() != colorIsWhite) {
                scope[sourceRank + direction][sourceFile - 1] = 'x';
            }
        }
        if(!hEdge) {
            Piece checkSquareForPiece = board[sourceRank + direction][sourceFile + 1].getPiece();
            if(checkSquareForPiece != null && checkSquareForPiece.isWhite() != colorIsWhite) {
                scope[sourceRank + direction][sourceFile + 1] = 'x';
            }
        }
    }

    @Override
    public boolean isWhite() {
        return colorIsWhite;
    }

    public char getDescription() {
        return description;
    }

    @Override
    public void setSquare(BoardSquare square) {
        this.square = square;
    }
}
