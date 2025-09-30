import java.util.Scanner;
import modules.Task_1;
import modules.Task_2;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Main started");

        System.out.println("\nReturned from Task_1");
        Task_1.main();

        System.out.println("\nReturned from Task_2");
        Task_2.main(sc);

        System.out.println("\nMain ended");
        sc.close();
    }
}
