package modules;

import java.util.*;
import java.util.regex.*;

public class Task_2 {
    // Task: Sentence analysis
    public static void main(Scanner sc) {
        System.out.println("Task_2 started");

        System.out.print("Enter a sentence to analyze: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split("[ ,]+");

        // Count words ending with "es"
        long countEs = Arrays.stream(words).filter(w -> w.endsWith("es")).count();

        // Sort words by length
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // Sum of integers in sentence
        int sumIntegers = 0;
        Pattern p = Pattern.compile("\\b\\d+\\b");
        Matcher m = p.matcher(sentence);
        while (m.find()) {
            sumIntegers += Integer.parseInt(m.group());
        }

        System.out.println("--- Sentence analysis results ---");
        System.out.println("Number of words ending with \"es\": " + countEs);
        System.out.println("Words sorted by length: " + Arrays.toString(words));
        System.out.println("Sum of all integers in sentence: " + sumIntegers);

        System.out.println("Task_SentenceAnalysis ended\n");
    }
}
