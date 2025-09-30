package modules;

import java.util.Scanner;

public class Task_4 {
    // 4. Check if password is strong (length 8-12, uppercase, lowercase, special symbols, punctuation)
    public static void main(Scanner sc) {
        System.out.println("Task_4 started");

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasSpecial = password.matches(".*[#@\\$%\\^&*<>].*");
        boolean hasPunct = password.matches(".*[.,!?;:].*");
        boolean lengthOk = password.length() >= 8 && password.length() <= 12;

        if (hasUpper && hasLower && hasSpecial && hasPunct && lengthOk) {
            System.out.println("Good password");
        } else {
            System.out.println("Bad password because:");
            if (!lengthOk) System.out.println(" - length must be 8..12");
            if (!hasUpper) System.out.println(" - missing uppercase letter");
            if (!hasLower) System.out.println(" - missing lowercase letter");
            if (!hasSpecial) System.out.println(" - missing special symbol (#,@,$,%,^,&,*,<,>)");
            if (!hasPunct) System.out.println(" - missing punctuation symbol");
        }

        System.out.println("Task_4 ended");
    }
}
