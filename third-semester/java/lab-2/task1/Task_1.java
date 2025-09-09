package task1;

import java.util.Random;

public class Task_1 {
    public static void main(String[] args) {
        Random rnd = new Random();

        // Create and fill an array of 20 integers in the range 0..1000
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1001); // nextInt(1001) gives 0..1000 inclusive
        }

        // Print the array (10 elements per line for readability)
        System.out.println("Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d%s", arr[i], (i % 10 == 9) ? System.lineSeparator() : " ");
        }
        if (arr.length % 10 != 0) System.out.println();

        // Count and sum three-digit symmetric numbers (palindromes)
        int count = 0;
        int sum = 0;
        for (int n : arr) {
            // check that the number is three-digit
            if (n >= 100 && n <= 999) {
                int hundreds = n / 100;   // hundreds digit
                int units = n % 10;       // units digit
                if (hundreds == units) {  // symmetric (palindrome)
                    count++;
                    sum += n;
                }
            }
        }

        // Result
        System.out.println("Three-digit symmetric numbers count: " + count);
        System.out.println("Sum of three-digit symmetric numbers: " + sum);
    }
}