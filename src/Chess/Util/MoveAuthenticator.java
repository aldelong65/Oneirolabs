package Chess.Util;

import Chess.Models.BoardSquare;
import Chess.Models.ChessBoard;
import Chess.Models.Move;
import Chess.Models.Piece;

import java.util.ArrayList;
import java.util.Hashtable;

public class MoveAuthenticator {
    public static boolean validateToken(String token) {
        token = token.trim().toLowerCase();
        if(token.length() == 2 || token.length() == 3) {
            char piece, file, rankChar;
            if(token.length() == 2) {
                file = token.charAt(0);
                rankChar = token.charAt(1);
            } else {
                piece = token.charAt(0);
                if(!Constants.PIECE_LIST.contains(piece)) {
                    System.err.println("Not a valid piece.");
                    return false;
                }
                file = token.charAt(1);
                rankChar = token.charAt(2);
            }
            if(Constants.FILE_LIST.contains(file)) {
                int rank = Character.getNumericValue(rankChar);
                if(rank < 1 || rank > 8) {
                    System.err.println("Not a valid rank.  Valid ranks: 3-8");
                    return false;
                }
            } else {
                System.err.println("Not a valid file.  Valid files: a-h");
                return false;
            }
        } else {
            System.err.println("Usage: Valid inputs follow the formats: e4 (pawn) or Nc3 (piece)");
            return false;
        }
        return true;
    }

    public static Hashtable<Piece, Move> validateMove(String token, Hashtable<Piece, ArrayList<Move>> moveList) {
        Hashtable<Piece, Move> validMoves = new Hashtable<>();

        if(token.length() == 2) {
            for(Piece piece : moveList.keySet()) {
                for(Move move : moveList.get(piece)) {
                    if(move.getDestination().getBoardSquareName().equals(token)) {
                        validMoves.put(piece, move);
                    }
                }
            }
        } else if(token.length() == 3) {

        }
        return validMoves;
    }
}
