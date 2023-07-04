
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("You have 5 attempts to guess the number");
        System.out.println("I have generated a random number between " + rangeStart + " and " + rangeEnd);
        
        Random random = new Random();
        int randomNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;

        Scanner scanner = new Scanner(System.in);
        boolean guessedCorrectly = false;
        
        while (!guessedCorrectly && maxAttempts > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                guessedCorrectly = true;
                score += maxAttempts;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
            
            maxAttempts--;
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts. The number was " + randomNumber);
        }
        
        System.out.println("Your score: " + score);
        
        System.out.print("Do you want to play again? (yes/no): ");
        String playAgain = scanner.next();
        
        if (playAgain.equalsIgnoreCase("yes")) {
            main(args);
        } else {
            System.out.println("Thank you for playing!");
        }
        
        scanner.close();
    }
}