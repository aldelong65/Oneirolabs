package Chess.Game;

import Chess.Models.BoardSquare;
import Chess.Models.ChessBoard;
import Chess.Models.Move;
import Chess.Models.Piece;
import Chess.Util.MoveAuthenticator;

import java.util.ArrayList;
import java.util.Hashtable;

public class GameController {
    private boolean whiteTurn;
    private ChessBoard chessBoard;
    private BoardSquare[][] board;
    private Hashtable<Piece, ArrayList<Move>> whitePieces;
    private Hashtable<Piece, ArrayList<Move>> blackPieces;
    private Hashtable<Piece, ArrayList<Move>> moveList;

    public GameController(){
        whiteTurn = true;
        chessBoard = new ChessBoard();
        board = chessBoard.getBoard();
    }

    public void generateMoveList() {
        moveList = new Hashtable<>();

        if(whiteTurn) {
            whitePieces = chessBoard.getWhitePieces();
            for(Piece piece : whitePieces.keySet()) {
                whitePieces.get(piece).clear();
                whitePieces.get(piece).addAll(piece.move(chessBoard));
                moveList.put(piece, whitePieces.get(piece));
            }
        } else {
            blackPieces = chessBoard.getBlackPieces();
            for(Piece piece : blackPieces.keySet()) {
                blackPieces.get(piece).clear();
                blackPieces.get(piece).addAll(piece.move(chessBoard));
                moveList.put(piece, blackPieces.get(piece));
            }
        }
    }

    public void movePiece(String token) {
        if(MoveAuthenticator.validateToken(token)) {
            Hashtable<Piece, Move> validMoves = MoveAuthenticator.validateMove(token, moveList);
            if(validMoves.isEmpty()) {
                System.out.println("There are no valid moves for " + token);
            } else if(validMoves.size() > 1) {
                System.out.println("There are multiple pieces that can move here");
            } else {
                Piece piece = (Piece)validMoves.keySet().toArray()[0];
                Move thisMove = validMoves.get(piece);
                thisMove.getDestination().setPiece(piece);
                thisMove.getDestination().setBoardSquareDescription(piece.getDescription());
                thisMove.getSource().setPiece(null);
                thisMove.getSource().setBoardSquareDescription('-');
            }
        }
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public boolean isWhiteTurn() { return whiteTurn; }

    public void switchTurns() { whiteTurn = !whiteTurn; }

    public BoardSquare[][] getBoard() {
        return board;
    }

    public void setBoard(BoardSquare[][] board) {
        this.board = board;
    }
}
