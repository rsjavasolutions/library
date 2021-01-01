package rs.java.library.mapper;

import rs.java.library.model.BookEntity;
import rs.java.library.request.BookRequest;
import rs.java.library.response.BookResponse;

public class BookMapper {

    public static BookEntity mapToEntity(BookRequest request) {
        return new BookEntity(
                request.getIsbn(),
                request.getAuthor(),
                request.getTitle()
        );
    }

    public static BookResponse mapToResponse(BookEntity entity) {
        return new BookResponse(
                entity.getId(),
                entity.getIsbn(),
                entity.getAuthor(),
                entity.getTitle()
        );
    }

}
