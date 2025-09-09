import java.util.Scanner;

import task1.Task_1;
import task2.Task_2;
import task3.Task_3;
import task4.Task_4;
import task5.Task_5;
import task6.Task_6;
import task7.Task_7;
import task8.Task_8;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Main started");  
        System.out.println("\nReturned from Task_1");         
        Task_1.main(args);
        System.out.println("\nReturned from Task_2"); 
        Task_2.main(args);
        System.out.println("\nReturned from Task_3");
        Task_3.main(sc);
        System.out.println("\nReturned from Task_4");
        Task_4.main(args);
        System.out.println("\nReturned from Task_5");
        Task_5.main(args);
        System.out.println("\nReturned from Task_6");
        Task_6.main(args);
        System.out.println("\nReturned from Task_7");
        Task_7.main(sc);
        System.out.println("\nReturned from Task_8");
        Task_8.main(args);
        System.out.println("\nMain ended");

        sc.close();
    }
}
