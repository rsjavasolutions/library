package rs.java.library.request;

public class BookRequest {
    private String isbn;
    private String author;
    private String title;

    public BookRequest() {
    }

    public BookRequest(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
