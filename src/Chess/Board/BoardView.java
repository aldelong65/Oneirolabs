package Chess.Board;

import Chess.Game.*;
import Chess.Models.BoardSquare;
import Chess.Util.*;

public class BoardView {
    private GameController gameController;

    public BoardView(GameController gameController) {
        this.gameController = gameController;
    }

    public void printBoardToTerminal() {
        BoardSquare[][] board = gameController.getBoard();
        for(int i = 0; i < 8; i++) {
            for(int k = 0; k < 8; k++) {
                System.out.print(board[i][k].getBoardSquareDescription() + " ");
            }
            System.out.println();
        }

    }

    public GameController getGameController() {
        return gameController;
    }
}
