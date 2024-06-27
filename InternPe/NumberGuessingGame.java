package InternPe;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxNumber = 100;
        int numberToGuess = random.nextInt(maxNumber) + 1;
        int numberOfAttempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and " + maxNumber + ". Try to guess it!");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int playerGuess = scanner.nextInt();
            numberOfAttempts++;

            if (playerGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (playerGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the correct number.");
                System.out.println("It took you " + numberOfAttempts + " attempts.");
            }
        }

        scanner.close();
    }
}
