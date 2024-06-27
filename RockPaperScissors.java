package InternPe;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] rps = {"Rock", "Paper", "Scissors"};
        String computerMove = rps[random.nextInt(rps.length)];

        String playerMove;

        while (true) {
            System.out.println("Enter your move (Rock, Paper, Scissors). To exit the game, type \"exit\": ");
            playerMove = scanner.nextLine();

            if (playerMove.equalsIgnoreCase("exit")) {
                break;
            }

            if (!playerMove.equalsIgnoreCase("Rock") &&
                    !playerMove.equalsIgnoreCase("Paper") &&
                    !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move, please try again.");
            } else {
                System.out.println("Computer move: " + computerMove);

                if (playerMove.equalsIgnoreCase(computerMove)) {
                    System.out.println("It's a tie!");
                } else if (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors") ||
                        playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock") ||
                        playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }

                computerMove = rps[random.nextInt(rps.length)]; // New computer move for the next round
            }
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}

