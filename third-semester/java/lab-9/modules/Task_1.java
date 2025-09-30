package modules;

import java.util.Arrays;

public class Task_1 {
    // Task: March temperature diary
    public static void main() {
        System.out.println("Task_1 started");

        int[] marchTemps = {-2, -5, -2, -4, 3, -6, -2, -1, 5, 1, 1, 0, -1, 0, 3, -1, 2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11};

        long negativeDays = Arrays.stream(marchTemps).filter(t -> t < 0).count();
        boolean above10 = Arrays.stream(marchTemps).anyMatch(t -> t > 10);
        int maxFirstWeek = Arrays.stream(marchTemps, 0, 7).max().orElse(Integer.MIN_VALUE);
        double avgTemp = Arrays.stream(marchTemps).average().orElse(Double.NaN);

        System.out.println("--- Temperature diary results ---");
        System.out.println("Number of negative temperature days: " + negativeDays);
        System.out.println("Any day above 10°C: " + (above10 ? "Yes" : "No"));
        System.out.println("Maximum temperature in first week: " + maxFirstWeek);
        System.out.printf("Average temperature for March: %.2f°C%n", avgTemp);

        System.out.println("Task_Temperature ended\n");
    }
}
