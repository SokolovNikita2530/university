package classes;

public class Book {
    private String title;
    private String author;

    public Book() {
        this.title = "";
        this.author = "";
    }

    public Book(String title, String author) {
        this.title = title == null ? "" : title;
        this.author = author == null ? "" : author;
    }

    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title == null ? "" : title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author == null ? "" : author; }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}
