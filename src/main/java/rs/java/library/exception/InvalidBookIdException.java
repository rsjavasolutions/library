package rs.java.library.exception;

public class InvalidBookIdException extends RuntimeException {
    public InvalidBookIdException() {
        super("INVALID BOOK ID");
    }
}
