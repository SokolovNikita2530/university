package modules;

import java.util.Scanner;

public class Task_5 {
    // 5. Find sum of all integers in text
    public static void main(Scanner sc) {
        System.out.println("Task_5 started");

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] tokens = input.split("[^0-9]+");
        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) sum += Integer.parseInt(token);
        }

        System.out.println("Sum of all integers: " + sum);

        System.out.println("Task_5 ended");
    }
}
