import java.util.Scanner;

import modules.Task_1;
import modules.Task_2;
import modules.Task_3;
import modules.Task_4;
import modules.Task_5;
import modules.Task_6;
import modules.Task_7;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Main started");

        System.out.println("\nReturned from Task_1");
        Task_1.main(sc);

        System.out.println("\nReturned from Task_2");
        Task_2.main(sc);

        System.out.println("\nReturned from Task_3");
        Task_3.main(sc);

        System.out.println("\nReturned from Task_4");
        Task_4.main(sc);

        System.out.println("\nReturned from Task_5");
        Task_5.main(sc);

        System.out.println("\nReturned from Task_6");
        Task_6.main(sc);

        System.out.println("\nReturned from Task_7");
        Task_7.main(sc);

        System.out.println("\nMain ended");

        sc.close();
    }
}
