package modules;

import java.util.Scanner;

public class Task_7 {
    // 7. Telegram price calculation (fixed)
    public static void main(Scanner sc) {
        System.out.println("Task_7 started");

        System.out.print("Enter telegram text: ");
        String text = sc.nextLine();

        int price = 0;
        StringBuilder converted = new StringBuilder();

        // Split by space
        String[] tokens = text.split("\\s+");
        for (String token : tokens) {
            if (token.isEmpty()) continue;

            // Separate punctuation at the end (comma)
            String word = token;
            boolean endsWithComma = word.endsWith(",");
            if (endsWithComma) word = word.substring(0, word.length() - 1);

            // Skip prepositions (1-2 letters)
            if (!word.isEmpty() && word.length() > 2) {
                converted.append(word).append(" ");
                price += 10;
            }

            // Process comma
            if (endsWithComma) {
                converted.append("zpt ").append(" ");
                price += 10;
            }
        }

        System.out.println("Price of telegram: " + price + " rub.");
        System.out.println("Converted text: " + converted.toString().trim());

        System.out.println("Task_7 ended");
    }
}
