public class Board {

    int[][] board = new int[6][7];
    int numberOfMoves = 0;

    public Board() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void printBoard() {
        numberOfMoves++;
        for (int i = 0; i < 6; i++) {
            System.out.print(" | ");
            for (int j = 0; j < 7; j++) {
                System.out.print((board[i][j] == 0 ? " " : board[i][j] == 1 ? "X" : "O") + " | ");
            }
            System.out.println();
        }
    }

    public boolean placePiece(int col, int piece) {
        if (col < 0 || col > 6) {
            return false;
        }
        if (board[0][col] != 0) {
            return false;
        }
        for (int i = 5; i >= 0; i--) {
            if (board[i][col] == 0) {
                board[i][col] = piece;
                return true;
            }
        }
        return false;
    }

    public int getWinner() {

        // 0 means the game is still going, player peices are 1 and 2
        if (numberOfMoves >= 42) {
            return -1;
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] != 0) {
                    // check horizontal
                    if (j < 4) {
                        if (board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2]
                                && board[i][j] == board[i][j + 3]) {
                            return board[i][j];
                        }
                    }
                    // check vertical
                    if (i < 3) {
                        if (board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j]
                                && board[i][j] == board[i + 3][j]) {
                            return board[i][j];
                        }
                    }
                    // check diagonal
                    if (i < 3 && j < 4) {
                        if (board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2]
                                && board[i][j] == board[i + 3][j + 3]) {
                            return board[i][j];
                        }
                    }
                    if (i > 2 && j < 4) {
                        if (board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2]
                                && board[i][j] == board[i - 3][j + 3]) {
                            return board[i][j];
                        }
                    }
                }
            }
        }

        return 0;

    }

}
