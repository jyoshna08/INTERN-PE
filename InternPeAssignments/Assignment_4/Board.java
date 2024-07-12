package InternPeAssignments.Assignment_4;

public class Board {
    private char[][] board;
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = ' ';
    private static final char PLAYER = 'X';
    private static final char COMPUTER = 'O';

    public Board() {
        board = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public boolean makeMove(int column, char player) {
        if (column < 0 || column >= COLUMNS) {
            return false;
        }
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == EMPTY) {
                board[i][column] = player;
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < COLUMNS; i++) {
            if (board[0][i] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(char player) {
        // Check horizontal
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] == player && board[row][col + 1] == player &&
                        board[row][col + 2] == player && board[row][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check vertical
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (board[row][col] == player && board[row + 1][col] == player &&
                        board[row + 2][col] == player && board[row + 3][col] == player) {
                    return true;
                }
            }
        }

        // Check diagonal (bottom-left to top-right)
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] == player && board[row - 1][col + 1] == player &&
                        board[row - 2][col + 2] == player && board[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check diagonal (top-left to bottom-right)
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] == player && board[row + 1][col + 1] == player &&
                        board[row + 2][col + 2] == player && board[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");
    }

    public int getRows() {
        return ROWS;
    }

    public int getColumns() {
        return COLUMNS;
    }

    public char getEmpty() {
        return EMPTY;
    }

    public char getPlayer() {
        return PLAYER;
    }

    public char getComputer() {
        return COMPUTER;
    }
}

