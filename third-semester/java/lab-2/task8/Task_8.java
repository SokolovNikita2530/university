package task8;

public class Task_8 {
    public static void main(String[] args) {
        int[] temps = {
            -2, -5, -2, -4,  3, -6, -2, -1,  5, 1, 1,
             0, -1,  0,  3, -1,  2,  5,  2,  4, 4, 0,
             6,  1,  4,  6, -1,  2,  4,  7, 11
        };

        // 1) Count negative->positive transitions (strict: prev < 0 and curr > 0)
        int negToPos = 0;
        for (int i = 1; i < temps.length; i++) {
            if (temps[i - 1] < 0 && temps[i] > 0) negToPos++;
        }

        // 2) Longest streak of consecutive positive days (strictly > 0)
        int maxPosStreak = 0;
        int curStreak = 0;
        for (int t : temps) {
            if (t > 0) {
                curStreak++;
                if (curStreak > maxPosStreak) maxPosStreak = curStreak;
            } else {
                curStreak = 0;
            }
        }

        // 3) Print results
        System.out.println("March temperatures (day: temp) and simple graph:");
        for (int i = 0; i < temps.length; i++) {
            int t = temps[i];
            System.out.printf("Day %2d: %3d | ", i + 1, t);
            if (t > 0) {
                for (int k = 0; k < t; k++) System.out.print('+');
            } else if (t < 0) {
                for (int k = 0; k < -t; k++) System.out.print('-');
            } else {
                System.out.print('0');
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Negative -> positive transitions: " + negToPos);
        System.out.println("Longest run of consecutive positive days: " + maxPosStreak);
    }
}
