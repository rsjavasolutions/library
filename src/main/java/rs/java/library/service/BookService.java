package rs.java.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.java.library.model.Book;
import rs.java.library.repository.BookRepository;

@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }
}
