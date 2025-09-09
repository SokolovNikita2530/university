package task4;

import java.util.Random;

public class Task_4 {
    public static void main(String[] args) {
        Random rnd = new Random();

        // Fill original array with 20 numbers in 1..1000
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1000) + 1; // 1..1000
        }

        // Print original array (10 elements per line)
        System.out.println("Original array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d%s", arr[i], (i % 10 == 9) ? System.lineSeparator() : " ");
        }
        if (arr.length % 10 != 0) System.out.println();

        // Collect numbers that end with digit 3
        int[] temp = new int[arr.length];
        int count = 0;
        for (int n : arr) {
            if (n % 10 == 3) {
                temp[count++] = n;
            }
        }

        if (count == 0) {
            System.out.println("No elements ending with digit 3 found.");
            return;
        }

        // Copy to result array of exact size
        int[] result = new int[count];
        for (int i = 0; i < count; i++) result[i] = temp[i];

        // Simple selection sort to sort in descending order (no extra imports)
        for (int i = 0; i < result.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] > result[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                int t = result[i];
                result[i] = result[maxIdx];
                result[maxIdx] = t;
            }
        }

        // Print filtered and sorted array
        System.out.println("Filtered & sorted (ending with 3, descending):");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%4d%s", result[i], ((i % 10 == 9) ? System.lineSeparator() : " "));
        }
        if (result.length % 10 != 0) System.out.println();
    }
}
