package task6;

import java.util.Arrays;

public class Task_6 {
    public static void main(String[] args) {
        final int N = 1_000_000;

        // Prepare source array (use same short literal to avoid huge memory use)
        String[] src = new String[N];
        for (int i = 0; i < N; i++) src[i] = "s";

        // Helper: run GC and pause to reduce noise
        warmupGc();

        // 1) Manual copy
        long t1 = System.nanoTime();
        String[] manual = new String[N];
        for (int i = 0; i < N; i++) manual[i] = src[i];
        long t2 = System.nanoTime();
        long manualMs = (t2 - t1) / 1_000_000;

        warmupGc();

        // 2) System.arraycopy
        t1 = System.nanoTime();
        String[] sys = new String[N];
        System.arraycopy(src, 0, sys, 0, N);
        t2 = System.nanoTime();
        long sysMs = (t2 - t1) / 1_000_000;

        warmupGc();

        // 3) Arrays.copyOf
        t1 = System.nanoTime();
        String[] arrCopy = Arrays.copyOf(src, N);
        t2 = System.nanoTime();
        long arraysMs = (t2 - t1) / 1_000_000;

        // Verify lengths and print results
        System.out.println("Source length: " + src.length);
        System.out.println("Manual copy length: " + manual.length + "  Time: " + manualMs + " ms");
        System.out.println("System.arraycopy length: " + sys.length + "  Time: " + sysMs + " ms");
        System.out.println("Arrays.copyOf length: " + arrCopy.length + "  Time: " + arraysMs + " ms");
    }

    private static void warmupGc() {
        try {
            System.gc();
            Thread.sleep(50);
        } catch (InterruptedException ignored) {}
    }
}
