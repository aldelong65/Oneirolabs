package Chess;

import Chess.Board.BoardView;
import Chess.Game.GameController;
import Chess.Util.Constants;

import java.util.Scanner;

public class Chess {
    public void startGame(Scanner in) {
        GameController gameController = new GameController();
        BoardView boardView = new BoardView(gameController);
        Constants.generateLists();
        gameController.generateMoveList();
        boardView.printBoardToTerminal();
        String token = in.next();
        gameController.movePiece(token);
        boardView.printBoardToTerminal();
    }
}
