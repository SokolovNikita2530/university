import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Part 1: integers
        ArrayList<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 3, -1, 7, 7, 0, -5, 12, 12, 4, -2);

        System.out.println("Integers list: " + ints);

        if (!ints.isEmpty()) {
            int max = Collections.max(ints);
            System.out.println("Max value: " + max);

            int lastIndexOfMax = -1;
            for (int i = ints.size() - 1; i >= 0; i--) {
                if (ints.get(i) == max) { lastIndexOfMax = i; break; }
            }
            System.out.println("Last index of max (0-based): " + lastIndexOfMax);

            // sort ascending
            Collections.sort(ints);
            System.out.println("Sorted ascending: " + ints);

            // optional: remove all negative numbers
            // simple approach: removeIf
            ints.removeIf(n -> n < 0);
            System.out.println("After removing negatives: " + ints);
        } else {
            System.out.println("Integer list is empty.");
        }

        System.out.println();
        // Part 2: real numbers
        LinkedList<Double> reals = new LinkedList<>();
        Collections.addAll(reals, 1.5, 0.0, -2.3, 4.0, 3.3, 0.0);

        System.out.println("Reals list: " + reals);

        if (!reals.isEmpty()) {
            // sort descending
            reals.sort(Collections.reverseOrder());
            System.out.println("Sorted descending: " + reals);

            // check for zero elements (exact zero)
            boolean hasZero = false;
            for (Double d : reals) if (d != null && d.doubleValue() == 0.0) { hasZero = true; break; }
            System.out.println("Contains zero element: " + hasZero);

            // insert average of first and last into middle
            double first = reals.getFirst();
            double last = reals.getLast();
            double avg = (first + last) / 2.0;
            int middle = reals.size() / 2;
            reals.add(middle, avg);
            System.out.println("After inserting average (" + avg + ") at index " + middle + ": " + reals);
        } else {
            System.out.println("Reals list is empty.");
        }
    }
}
