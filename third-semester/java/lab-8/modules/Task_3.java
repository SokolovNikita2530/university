package modules;

import java.util.Scanner;

public class Task_3 {
    // 3. Count three-letter words in a sentence (words separated by spaces/commas)
    public static void main(Scanner sc) {
        System.out.println("Task_3 started");

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = input.split("[ ,]+");
        int count = 0;
        for (String w : words) {
            if (w.length() == 3) count++;
        }

        System.out.println("Count of three-letter words: " + count);

        System.out.println("Task_3 ended");
    }
}
