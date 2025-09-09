package task5;

import java.util.Random;

public class Task_5 {
    public static void main(String[] args) {
        Random rnd = new Random();

        int rows = 8, cols = 8;
        int[][] m = new int[rows][cols];

        // Fill matrix with random integers -10..10
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = rnd.nextInt(21) - 10; // 0..20 -> -10..10
            }
        }

        // Print matrix
        System.out.println("Matrix 8x8:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", m[i][j]);
            }
            System.out.println();
        }

        // Find and print local minima (strictly less than up/down/left/right)
        int count = 0;
        System.out.println("\nLocal minima (row,col) [0-based] : value");
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                int v = m[i][j];
                if (v < m[i-1][j] && v < m[i+1][j] && v < m[i][j-1] && v < m[i][j+1]) {
                    System.out.printf("(%d,%d) : %d%n", i, j, v);
                    count++;
                }
            }
        }

        System.out.println("\nTotal local minima: " + count);
    }
}
