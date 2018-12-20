package Chess.Models;

import java.util.ArrayList;

public class BoardSquare {
    private String boardSquareName;
    private char file;
    private int rank;
    private char boardSquareDescription;
    private Piece piece = null;
    private ArrayList<Move> moveList = null;

    public BoardSquare(String squareName) {
        boardSquareName = squareName;
        file = boardSquareName.charAt(0);
        rank = Character.getNumericValue(boardSquareName.charAt(1));
        boardSquareDescription = '-';
    }

    public String getBoardSquareName() {
        return boardSquareName;
    }

    public void setBoardSquareName(String boardSquareName) {
        this.boardSquareName = boardSquareName;
    }

    public char getFile() {
        return file;
    }

    public void setFile(char file) {
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public char getBoardSquareDescription() {
        return boardSquareDescription;
    }

    public void setBoardSquareDescription(char boardSquareDescription) {
        this.boardSquareDescription = boardSquareDescription;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public ArrayList<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(ArrayList<Move> moveList) {
        this.moveList = moveList;
    }
}
