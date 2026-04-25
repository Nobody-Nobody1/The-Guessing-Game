import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int attempts = 0;
        boolean guessedCorrectly = false;

        int MIN = 0;       // Minimum possible number
        int MAX = 100;     // Maximum possible number

        System.out.println("=== Welcome to the Number Guessing Game ===");
        
        int targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
        System.out.println("I have chosen a number between " + MIN + " and " + MAX + ".");

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");

            try {
                int guess = scanner.nextInt();

                // Validate range
                if (guess < MIN || guess > MAX) {
                    System.out.println("Please enter a number between " + MIN + " and " + MAX + ".");
                    continue;
                }

                attempts++;

                if (guess == targetNumber) {
                    guessedCorrectly = true;
                    System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.close();
    }
}