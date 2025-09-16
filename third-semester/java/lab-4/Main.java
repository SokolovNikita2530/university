import classes.Book;
import classes.Reader;

public class Main {
    public static void main(String[] args) {
        // Petrov: Schildt "Java 8. Complete Guide", due 1 April (1/4)
        Book schildt = new Book("Java 8. Complete Guide", "G. Schildt");
        Reader petrov = new Reader("Petrov", schildt, 1, 4);

        // Vasechkin: Tolstoy "The Kreutzer Sonata", due 25 March (25/3)
        Book tolstoy = new Book("The Kreutzer Sonata", "L. Tolstoy");
        Reader vasechkin = new Reader("Vasechkin", tolstoy, 25, 3);

        // Both returned on 29 March
        int returnDay = 29;
        int returnMonth = 3;

        checkAndPrint(petrov, returnDay, returnMonth);
        checkAndPrint(vasechkin, returnDay, returnMonth);
    }

    private static void checkAndPrint(Reader r, int day, int month) {
        boolean onTime = r.returnedOnTime(day, month);
        System.out.println(r.getName() + " returned " + r.getBook() + " on " + day + "/" + month +
                           " -> " + (onTime ? "on time" : "LATE"));
    }
}
