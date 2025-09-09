import classes.Bus;

public class Main {
    public static void main(String[] args) {
        // Create two buses as required
        Bus bus1 = new Bus(54, 400); // 54 seats, 400 per seat
        Bus bus2 = new Bus(45, 500); // 45 seats, 500 per seat

        int groupA = 25;
        int groupB = 30;

        // Try the straightforward distribution: A->bus1, B->bus2
        Bus b1 = new Bus(bus1); // copies to preserve originals for other trials
        Bus b2 = new Bus(bus2);
        boolean aFits = b1.addPassengers(groupA);
        boolean bFits = b2.addPassengers(groupB);

        System.out.println("Initial distribution attempt (A->bus1, B->bus2):");
        if (!aFits || !bFits) {
            System.out.println("  One of the groups does not fit in the assigned bus.");
        }
        System.out.println("  " + b1);
        System.out.println("  " + b2);
        printProfitability(b1, b2, 11000);

        // Try swapped distribution: A->bus2, B->bus1
        Bus b1s = new Bus(bus1);
        Bus b2s = new Bus(bus2);
        boolean aFitsSwapped = b2s.addPassengers(groupA);
        boolean bFitsSwapped = b1s.addPassengers(groupB);

        System.out.println("\nSwapped distribution attempt (A->bus2, B->bus1):");
        if (!aFitsSwapped || !bFitsSwapped) {
            System.out.println("  One of the groups does not fit in the assigned bus.");
        }
        System.out.println("  " + b1s);
        System.out.println("  " + b2s);
        printProfitability(b1s, b2s, 11000);

        // Find a distribution where both buses are profitable (threshold 11000)
        int threshold = 11000;
        Distribution dist = findProfitableDistribution(bus1, bus2, groupA, groupB, threshold);
        System.out.println("\nSearch for distribution where BOTH buses are profitable (> " + threshold + "):");
        if (dist == null) {
            System.out.println("  No distribution found where both buses are profitable.");
        } else {
            System.out.println("  Found distribution: " + dist);
        }

        // Additional task: given several small groups, count how many fit in bus1 (sequential, no splitting)
        int[] smallGroups = {10, 12, 8, 5, 7, 3, 9};
        int fitCount = countGroupsFitSequentially(bus1, smallGroups);
        System.out.println("\nSmall groups: number that fit sequentially into bus1: " + fitCount +
                           " (groups attempted in order)");
    }

    private static void printProfitability(Bus b1, Bus b2, int threshold) {
        System.out.println("  Profitability (threshold " + threshold + "):");
        System.out.println("    Bus1 revenue = " + b1.totalRevenue() +
                           (b1.totalRevenue() > threshold ? "  PROFITABLE" : "  not profitable"));
        System.out.println("    Bus2 revenue = " + b2.totalRevenue() +
                           (b2.totalRevenue() > threshold ? "  PROFITABLE" : "  not profitable"));
    }

    // Result holder for distribution
    private static class Distribution {
        final int groupForBus1;
        final int groupForBus2;
        Distribution(int g1, int g2) { this.groupForBus1 = g1; this.groupForBus2 = g2; }
        @Override public String toString() {
            return "bus1 <- " + groupForBus1 + " , bus2 <- " + groupForBus2;
        }
    }

    /*
      Try to find assignment of two groups (gA and gB) to two buses without splitting
      so that BOTH buses revenue > threshold. Returns Distribution or null.
      Placed in Main for simplicity (could be in separate manager class).
    */
    private static Distribution findProfitableDistribution(Bus bus1, Bus bus2,
                                                           int gA, int gB, int threshold) {
        // Option 1: A -> bus1, B -> bus2
        Bus t1 = new Bus(bus1);
        Bus t2 = new Bus(bus2);
        if (t1.addPassengers(gA) && t2.addPassengers(gB)) {
            if (t1.totalRevenue() > threshold && t2.totalRevenue() > threshold) {
                return new Distribution(gA, gB);
            }
        }

        // Option 2: A -> bus2, B -> bus1
        Bus s1 = new Bus(bus1);
        Bus s2 = new Bus(bus2);
        if (s1.addPassengers(gB) && s2.addPassengers(gA)) {
            if (s1.totalRevenue() > threshold && s2.totalRevenue() > threshold) {
                return new Distribution(gB, gA);
            }
        }

        return null;
    }

    // Count how many groups (in order) fit into the bus without splitting
    private static int countGroupsFitSequentially(Bus busTemplate, int[] groups) {
        Bus b = new Bus(busTemplate); // work on a copy
        int count = 0;
        for (int g : groups) {
            if (b.addPassengers(g)) count++;
            else break;
        }
        return count;
    }
}
