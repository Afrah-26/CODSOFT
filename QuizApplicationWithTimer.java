import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplicationWithTimer {
    private static String[] questions = {
            "Number of primitive data types in Java are?",
            "What is the size of float and double in java",
            "Automatic type conversion is possible in which of the possible cases?",
            "Arrays in java are?"
    };

    private static String[][] options = {
            {"1. 7", "2. 8", "3. 4", "4. 6"},
            {"1. 32 to 64", "2. 64 to 32", "3. 64 to 64", "4. 32 to 32"},
            {"1. byte to int", "2. int to long", "3. long to int", "4. short to int"},
            {"1. Object references", "2. Primitive data type", "3. Objects", "4. None"}
    };

    private static int[] correctAnswers = {2, 1, 2, 3};
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            // Timer setup
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    System.out.println("You missed this question.");
                    System.out.println();
                    timer.cancel();
                    System.exit(0);
                }
            };
            timer.schedule(task, 20000); // 20 seconds for each question

            // Get the answer
            int answer = scanner.nextInt();

            // Stop the timer if the user answers in time
            timer.cancel();

            // Validate the user's answer
            if (answer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }

            System.out.println();
        }

        // Display the final score
        System.out.println("Quiz over!  \nCONGRATULATIONS..! Your final score is: " + score + "/" + questions.length);
    }
}
