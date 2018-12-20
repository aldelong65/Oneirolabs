import Chess.Chess;

import java.util.Scanner;

public class Oneirolab {
    public static void main(String args[]) {
        System.out.println(" =====================================================================");
        System.out.println("|\t____ _  _ ____ _ ____ ____ ___  ____ ___ . ____    _    ____ ___\t|\n" +
                "|\t|  | |\\ | |___ | |__/ |  | |__] |  |  |  ' [__     |    |__| |__]\t|\n" +
                "|\t|__| | \\| |___ | |  \\ |__| |__] |__|  |    ___]    |___ |  | |__]\t|\n");
        System.out.println(" =====================================================================");
        runLabs();
    }

    private static void runLabs() {
        Scanner in = new Scanner(System.in);
        while(true) {
            Chess chess = new Chess();
            chess.startGame(in);
            break;
        }
    }
}