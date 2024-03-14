
/**
 * Write a description of class ConnectFour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class ConnectFour {

    public static void main(String[] args) {

        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        int currentPlayer = 1;
        while (board.getWinner() == 0) {
            board.printBoard();

            System.out.println("Player " + currentPlayer + " enter a column number: ");
            int col = scanner.nextInt();
            if (board.placePiece(col, currentPlayer)) {
                if (currentPlayer == 1) {
                    currentPlayer = 2;
                } else {
                    currentPlayer = 1;
                }
            } else {
                System.out.println("Invalid move");
            }

        }

        board.printBoard();
        int winner = board.getWinner();
        if (winner == -1) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player " + winner + " wins!");
        }

        scanner.close();

    }

}
