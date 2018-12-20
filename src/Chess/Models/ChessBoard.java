package Chess.Models;

import Chess.Util.BoardUtil;

import java.util.ArrayList;
import java.util.Hashtable;

public class ChessBoard {
    private String fenBoard;
    private BoardSquare[][] board;
    private Hashtable<String, BoardSquare> coordinateTable;
    private Hashtable<Piece, ArrayList<Move>> whitePieces = new Hashtable<>();
    private Hashtable<Piece, ArrayList<Move>> blackPieces = new Hashtable<>();

    public ChessBoard() {
        fenBoard = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        coordinateTable = BoardUtil.buildCoordinateTable();
        board = BoardUtil.fenToBoard(fenBoard, coordinateTable, whitePieces, blackPieces);
    }

    public ChessBoard(String fenString) {
        fenBoard = fenString;
        coordinateTable = BoardUtil.buildCoordinateTable();
        board = BoardUtil.fenToBoard(fenBoard, coordinateTable, whitePieces, blackPieces);
    }

    public String getFenBoard() {
        return fenBoard;
    }

    public void setFenBoard(String fenBoard) {
        this.fenBoard = fenBoard;
    }

    public BoardSquare[][] getBoard() {
        return board;
    }

    public void setBoard(BoardSquare[][] board) {
        this.board = board;
    }

    public Hashtable<String, BoardSquare> getCoordinateTable() {
        return coordinateTable;
    }

    public void setCoordinateTable(Hashtable<String, BoardSquare> coordinateTable) {
        this.coordinateTable = coordinateTable;
    }

    public Hashtable<Piece, ArrayList<Move>> getWhitePieces() {
        return whitePieces;
    }

    public void setWhitePieces(Hashtable<Piece, ArrayList<Move>> whitePieces) {
        this.whitePieces = whitePieces;
    }

    public Hashtable<Piece, ArrayList<Move>> getBlackPieces() {
        return blackPieces;
    }

    public void setBlackPieces(Hashtable<Piece, ArrayList<Move>> blackPieces) {
        this.blackPieces = blackPieces;
    }
}
