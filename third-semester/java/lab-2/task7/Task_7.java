package task7;

import java.util.Random;
import java.util.Scanner;

public class Task_7 {
    public static void main(Scanner sc) {
        System.out.print("Enter number of players: ");
        int N;
        try {
            N = sc.nextInt();
        } catch (Exception e) {
            System.err.println("Invalid input.");
            sc.close();
            return;
        }

        if (N <= 0) {
            System.out.println("Number of players must be positive.");
            sc.close();
            return;
        }

        final int CARDS_PER_PLAYER = 5;
        final int DECK_SIZE = 52;
        if ((long) N * CARDS_PER_PLAYER > DECK_SIZE) {
            System.out.println("Too many players. Not enough cards for " + N + " players.");
            sc.close();
            return;
        }

        String[] ranks = {
            "2","3","4","5","6","7","8","9","10","J","Q","K","A"
        };
        String[] suits = { "S", "H", "D", "C" };

        // build deck
        String[] deck = new String[DECK_SIZE];
        int idx = 0;
        for (String s : suits) {
            for (String r : ranks) {
                deck[idx++] = r + s;
            }
        }

        // shuffle (Fisher-Yates)
        Random rnd = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            String t = deck[i];
            deck[i] = deck[j];
            deck[j] = t;
        }

        // deal and print
        System.out.println("\nDealing " + CARDS_PER_PLAYER + " cards to " + N + " players:\n");
        for (int p = 0; p < N; p++) {
            System.out.printf("Player %d: ", p + 1);
            for (int c = 0; c < CARDS_PER_PLAYER; c++) {
                if (c > 0) System.out.print(", ");
                System.out.print(deck[p * CARDS_PER_PLAYER + c]);
            }
            System.out.println();
        }
    }
}
