package modules;

import java.util.Scanner;

public class Task_6 {
    // 6. Find sentences that contain a keyword
    public static void main(Scanner sc) {
        System.out.println("Task_6 started");

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        String[] sentences = text.split("[.!?]");
        System.out.println("Sentences containing keyword:");
        for (String s : sentences) {
            String[] words = s.trim().split("\\s+");
            for (String w : words) {
                if (w.equals(keyword)) {
                    System.out.println(s.trim());
                    break;
                }
            }
        }

        System.out.println("Task_6 ended");
    }
}
