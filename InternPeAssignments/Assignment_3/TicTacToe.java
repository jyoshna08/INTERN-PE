package InternPeAssignments.Assignment_3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayerMark;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayerMark = 'X'; // Player 1 starts with 'X'
        initializeBoard();
    }

    // Initialize board with empty spots
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the current board
    public void printBoard() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check if the board is full
    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    // Check for a win
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    // Check rows for a win
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    // Check columns for a win
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    // Check diagonals for a win
    private boolean checkDiagonalsForWin() {
        return (checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]));
    }

    // Check if all three values are the same (non-'-') to signify a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    // Change player marks
    public void changePlayer() {
        currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
    }

    // Get user move
    public void getUserMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.println("Player " + currentPlayerMark + ", enter your move (row[1-3] column[1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));
        board[row][col] = currentPlayerMark;
    }

    // Check if the move is valid
    private boolean isValidMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            return true;
        } else {
            System.out.println("Invalid move. Please try again.");
            return false;
        }
    }

    // Get computer move (randomly)
    public void getComputerMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(row, col));
        board[row][col] = currentPlayerMark;
    }

    // Main method to run the game
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.printBoard();

        while (!game.isBoardFull() && !game.checkForWin()) {
            if (game.currentPlayerMark == 'X') {
                game.getUserMove();
            } else {
                game.getComputerMove();
            }
            game.changePlayer();
            game.printBoard();
        }

        if (game.checkForWin()) {
            game.changePlayer(); // Switch player back to winner
            System.out.println("Player " + game.currentPlayerMark + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
