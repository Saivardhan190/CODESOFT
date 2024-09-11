import java.util.*;
import java.util.concurrent.*;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class task4 {
    private static final List<Question> questions = new ArrayList<>();
    private static int score = 0;

    public static void main(String[] args) {
        // Initialize questions
        questions.add(new Question("What is the capital of India?", new String[]{"1. Berlin", "2. Delhi", "3. Paris", "4. Rome"}, 2));
        questions.add(new Question("What is 6 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 8"}, 4));
        // Add more questions as needed

        try (Scanner scanner = new Scanner(System.in)) {
            for (Question q : questions) {
                System.out.println(q.question);
                for (String option : q.options) {
                    System.out.println(option);
                }

                // Timer for each question
                ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                Future<Integer> future = executor.submit(() -> {
                    System.out.print("Enter your answer: ");
                    return scanner.nextInt();
                });

                try {
                    int answer = future.get(10, TimeUnit.SECONDS); // 10 seconds to answer
                    if (answer == q.correctAnswer) {
                        score++;
                    }
                } catch (TimeoutException e) {
                    System.out.println("Time's up!");
                    future.cancel(true);
                } catch (InterruptedException | ExecutionException e) {
                } finally {
                    executor.shutdown();
                }
            }
        }

        // Display result
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}
