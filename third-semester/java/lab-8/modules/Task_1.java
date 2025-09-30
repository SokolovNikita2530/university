package modules;

import java.util.Scanner;

public class Task_1 {
    // 1. Input a word and remove all uppercase letters
    public static void main(Scanner sc) {
        System.out.println("Task_1 started");

        System.out.print("Enter a word: ");
        String input = sc.nextLine();

        String result = input.replaceAll("[A-Z]", "");
        System.out.println("Result (without uppercase letters): " + result);

        System.out.println("Task_1 ended");
    }
}

