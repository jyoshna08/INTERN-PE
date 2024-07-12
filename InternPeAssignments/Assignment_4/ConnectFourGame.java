package InternPeAssignments.Assignment_4;

import java.util.Scanner;

public class ConnectFourGame {
    private Board board;
    private ComputerPlayer computerPlayer;
    private Scanner scanner;

    public ConnectFourGame() {
        board = new Board();
        computerPlayer = new ComputerPlayer();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Connect Four!");
        board.printBoard();

        while (true) {
            playerMove();
            board.printBoard();
            if (board.checkWin(board.getPlayer())) {
                System.out.println("Congratulations! You win!");
                break;
            }
            if (board.isFull()) {
                System.out.println("The game is a draw!");
                break;
            }

            computerMove();
            board.printBoard();
            if (board.checkWin(board.getComputer())) {
                System.out.println("Computer wins!");
                break;
            }
            if (board.isFull()) {
                System.out.println("The game is a draw!");
                break;
            }
        }

        System.out.println("Game over.");
    }

    private void playerMove() {
        int column;
        while (true) {
            System.out.print("Enter a column (0-6): ");
            column = scanner.nextInt();
            if (board.makeMove(column, board.getPlayer())) {
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private void computerMove() {
        System.out.println("Computer's turn...");
        computerPlayer.getMove(board);
    }

    public static void main(String[] args) {
        ConnectFourGame game = new ConnectFourGame();
        game.start();
    }
}

