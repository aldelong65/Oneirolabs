package Chess.Util;

import Chess.Models.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class BoardUtil {
    public static BoardSquare[][] fenToBoard(String fen,
                                             Hashtable<String, BoardSquare> coordinateTable,
                                             Hashtable<Piece, ArrayList<Move>> whitePieces,
                                             Hashtable<Piece, ArrayList<Move>> blackPieces) {
        String[] fenRowSet = fen.split("/");
        BoardSquare[][] board = buildBoard(coordinateTable);
        for (int fenRank = 0; fenRank < 8; fenRank++) {
            if (fenRowSet[fenRank].length() != 1) {
                int boardFile = 0;
                for (int index = 0; index < fenRowSet[fenRank].length(); index++) {
                    char c = fenRowSet[fenRank].charAt(index);
                    if (Character.isDigit(c)) {
                        boardFile += Character.getNumericValue(c);
                    } else {
                        boolean isWhite = Character.isUpperCase(c);
                        BoardSquare square = board[fenRank][boardFile];
                        c = Character.toLowerCase(c);
                        switch (c) {
                            case 'p':
                                Piece pawn = new Pawn(isWhite, square);
                                if (isWhite) {
                                    whitePieces.put(pawn, new ArrayList<Move>());
                                } else {
                                    blackPieces.put(pawn, new ArrayList<Move>());
                                }
                                square.setPiece(pawn);
                                square.setBoardSquareDescription(pawn.getDescription());
                                break;
                            case 'r':
                                Piece rook = new Rook(isWhite, square);
                                if (isWhite) {
                                    whitePieces.put(rook, new ArrayList<Move>());
                                } else {
                                    blackPieces.put(rook, new ArrayList<Move>());
                                }
                                square.setPiece(rook);
                                square.setBoardSquareDescription(rook.getDescription());
                                break;
                            case 'n':
                                Piece knight = new Knight(isWhite, square);
                                if (isWhite) {
                                    whitePieces.put(knight, new ArrayList<Move>());
                                } else {
                                    blackPieces.put(knight, new ArrayList<Move>());
                                }
                                square.setPiece(knight);
                                square.setBoardSquareDescription(knight.getDescription());
                                break;
                            case 'b':
                                Piece bishop = new Bishop(isWhite, square);
                                if (isWhite) {
                                    whitePieces.put(bishop, new ArrayList<Move>());
                                } else {
                                    blackPieces.put(bishop, new ArrayList<Move>());
                                }
                                square.setPiece(bishop);
                                square.setBoardSquareDescription(bishop.getDescription());
                                break;
                            case 'q':
                                Piece queen = new Queen(isWhite, square);
                                if (isWhite) {
                                    whitePieces.put(queen, new ArrayList<Move>());
                                } else {
                                    blackPieces.put(queen, new ArrayList<Move>());
                                }
                                square.setPiece(queen);
                                square.setBoardSquareDescription(queen.getDescription());
                                break;
                            case 'k':
                                Piece king = new King(isWhite, square);
                                if (isWhite) {
                                    whitePieces.put(king, new ArrayList<Move>());
                                } else {
                                    blackPieces.put(king, new ArrayList<Move>());
                                }
                                square.setPiece(king);
                                square.setBoardSquareDescription(king.getDescription());
                                break;
                            default:
                                break;
                        }
                        boardFile++;
                    }
                }
            }
        }
        return board;
    }

    private static BoardSquare[][] buildBoard(Hashtable<String, BoardSquare> coordinateTable) {
        BoardSquare[][] board = new BoardSquare[8][8];
        for (int column = 0, index = 0; column < 8; column++) {
            for (int row = 7; row >= 0; row--, index++) {
                board[row][column] = coordinateTable.get(Constants.COORDINATE_LIST[index]);
            }
        }
        return board;
    }

    public static char[][] buildCharBoard(BoardSquare[][] board) {
        char[][] charBoard = new char[8][8];
        for (int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                charBoard[row][column] = board[row][column].getBoardSquareDescription();
            }
        }
        return charBoard;
    }

    public static Hashtable<String, BoardSquare> buildCoordinateTable() {
        Hashtable<String, BoardSquare> coordinateTable = new Hashtable<>();
        for (int coordinateIndex = 0; coordinateIndex < 64; coordinateIndex++) {
            coordinateTable.put(Constants.COORDINATE_LIST[coordinateIndex],
                    new BoardSquare(Constants.COORDINATE_LIST[coordinateIndex]));
        }
        return coordinateTable;
    }
}
