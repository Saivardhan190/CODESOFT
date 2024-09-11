import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        try (Scanner myObj = new Scanner(System.in)) {
            int maxAttempts = 5;
            int score = 0;
            boolean playAgain = true;
            
            while (playAgain) {
                int targetNumber = 46;
                int attempts = 0;
                
                System.out.println("Enter a number between 0 and 99. You have " + maxAttempts + " attempts.");
                
                while (attempts < maxAttempts) {
                    int number = myObj.nextInt();
                    attempts++;
                    
                    if (number == targetNumber) {
                        System.out.println("Correct number!");
                        score += maxAttempts - attempts + 1;
                        break;
                    } else if (number > targetNumber) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Too low!");
                    }
                    
                    if (attempts == maxAttempts) {
                        System.out.println("You're out of attempts! The target number was: " + targetNumber);
                    }
                }
                
                System.out.println("Your score: " + score);
                System.out.print("Play again? (y/n): ");
                String playAgainInput = myObj.next();
                playAgain = playAgainInput.equalsIgnoreCase("y");
            }
            
            System.out.println("Thanks for playing! Final score: " + score);
        }
    }
}