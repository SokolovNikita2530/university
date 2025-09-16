package classes;

public class Reader {
    private String name;
    private Book book;
    private int dueDay;
    private int dueMonth; // 1..12

    public Reader() {
        this.name = "";
        this.book = new Book();
        this.dueDay = 1;
        this.dueMonth = 1;
    }

    public Reader(String name, Book book, int dueDay, int dueMonth) {
        this.name = name == null ? "" : name;
        this.book = book == null ? new Book() : new Book(book);
        this.dueDay = Math.max(1, Math.min(31, dueDay));
        this.dueMonth = Math.max(1, Math.min(12, dueMonth));
    }

    public Reader(Reader other) {
        this.name = other.name;
        this.book = new Book(other.book);
        this.dueDay = other.dueDay;
        this.dueMonth = other.dueMonth;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name == null ? "" : name; }

    public Book getBook() { return new Book(book); }
    public void setBook(Book book) { this.book = book == null ? new Book() : new Book(book); }

    public int getDueDay() { return dueDay; }
    public void setDueDay(int dueDay) { this.dueDay = Math.max(1, Math.min(31, dueDay)); }

    public int getDueMonth() { return dueMonth; }
    public void setDueMonth(int dueMonth) { this.dueMonth = Math.max(1, Math.min(12, dueMonth)); }

    // Return true if returned on or before due date (compare month then day)
    public boolean returnedOnTime(int returnDay, int returnMonth) {
        if (returnMonth < dueMonth) return true;
        if (returnMonth > dueMonth) return false;
        return returnDay <= dueDay;
    }

    @Override
    public String toString() {
        return name + " (due " + dueDay + "/" + dueMonth + ") -> " + book.toString();
    }
}