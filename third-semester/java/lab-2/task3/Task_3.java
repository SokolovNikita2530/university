package task3;

import java.util.Scanner;
import static java.lang.Math.*;

public class Task_3 {
    public static void main(Scanner sc) {

        System.out.print("Enter A: ");
        double A = sc.nextDouble();
        System.out.print("Enter B: ");
        double B = sc.nextDouble();
        System.out.print("Enter step E: ");
        double E = sc.nextDouble();

        if (E == 0.0) {
            System.err.println("Step E must not be zero.");
            sc.close();
            return;
        }

        final double eps = 1e-12;
        boolean forward = E > 0;
        if ((forward && A > B + eps) || (!forward && A < B - eps)) {
            System.err.println("Step direction incompatible with A and B.");
            sc.close();
            return;
        }

        // Count number of points (iterate by index to avoid accumulation error)
        int maxIter = 1_000_000;
        int count = 0;
        for (int i = 0; i < maxIter; i++) {
            double x = A + i * E;
            if (forward) {
                if (x > B + eps) break;
            } else {
                if (x < B - eps) break;
            }
            count++;
        }

        if (count == 0) {
            System.out.println("No points to compute with given A, B, E.");
            sc.close();
            return;
        }

        // Create table [4][count]
        double[][] table = new double[4][count];
        for (int i = 0; i < count; i++) {
            double x = A + i * E;
            table[0][i] = x;
            table[1][i] = x * x - 10.0 * x + 15.0;
            table[2][i] = 2.0 * sin(x + PI / 3.0);
            table[3][i] = x >= 0.0 ? exp(sqrt(x)) : Double.NaN;
        }

        // Print header and rows with improved formatting
        String h1 = "x";
        String h2 = "f1 = x^2-10x+15";
        String h3 = "f2 = 2*sin(x+π/3)";
        String h4 = "f3 = e^(√x)";
        System.out.printf("%12s | %18s | %18s | %18s%n", h1, h2, h3, h4);
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%12.6f | %18.6f | %18.6f | %18.6f%n",
                    table[0][i], table[1][i], table[2][i], table[3][i]);
        }

    }
}
