package rs.java.library.response;

public class BookResponse {
    private final Integer id;
    private final String isbn;
    private final String author;
    private final String title;

    public BookResponse(Integer id, String isbn, String author, String title) {
        this.id = id;
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    public Integer getId() {
        return id;
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
