package modules;

import java.util.Scanner;

public class Task_2 {
    // 2. Input a text where each word is written reversed. Decode the message.
    public static void main(Scanner sc) {
        System.out.println("Task_2 started");

        System.out.print("Enter text (words reversed): ");
        String input = sc.nextLine();

        StringBuilder decoded = new StringBuilder();
        for (String word : input.split(" ")) {
            decoded.append(new StringBuilder(word).reverse()).append(" ");
        }

        System.out.println("Decoded text: " + decoded.toString().trim());

        System.out.println("Task_2 ended");
    }
}
