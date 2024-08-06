package Task1;

import java.util.Scanner;

public class Tictactoe {
    private static final int SIZE = 3;
    private static char[][] board = new char[SIZE][SIZE];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean playAgain = true;

            while (playAgain) {
                initializeBoard();
                boolean gameEnd = false;
                while (!gameEnd) {
                    printBoard();
                    playerMove(sc);
                    gameEnd = checkWinner() || checkDraw();
                    if (!gameEnd) {
                        switchPlayer();
                    }
                }
                printBoard();
                System.out.println("Game Over! Play Again? (yes/no): ");
                playAgain = sc.next().equalsIgnoreCase("yes");
            }
        }
    }

    private static boolean checkDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        System.out.println("The game is a draw!");
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWinner() {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                System.out.println("Player " + currentPlayer + " wins!");
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                System.out.println("Player " + currentPlayer + " wins!");
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            System.out.println("Player " + currentPlayer + " wins!");
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            System.out.println("Player " + currentPlayer + " wins!");
            return true;
        }
        return false;
    }

    private static void playerMove(Scanner sc) {
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = sc.nextInt() - 1;
            col = sc.nextInt() - 1;
            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid!");
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }
}
