package task2;

import java.util.Random;

public class Task_2 {
    public static void main(String[] args) {
        Random rnd = new Random();

        // Create and fill an array of 20 integers in the range 0..1000
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1001); // 0..1000 inclusive
        }

        // Print the array (10 elements per line)
        System.out.println("Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d%s", arr[i], (i % 10 == 9) ? System.lineSeparator() : " ");
        }
        if (arr.length % 10 != 0) System.out.println();

        // Find the maximum even number in the array
        Integer maxEven = null; // use Integer to represent "no even found" as null
        for (int n : arr) {
            if (n % 2 == 0) {
                if (maxEven == null || n > maxEven) {
                    maxEven = n;
                }
            }
        }

        // Output result
        if (maxEven == null) {
            System.out.println("No even numbers found in the array.");
        } else {
            System.out.println("Maximum even number: " + maxEven);
        }
    }
}