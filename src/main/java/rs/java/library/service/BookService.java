package rs.java.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.java.library.exception.InvalidBookIdException;
import rs.java.library.model.Book;
import rs.java.library.repository.BookRepository;

import java.util.Optional;

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

    public Book getById(Integer id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            return optionalBook.get();
        }
        throw new InvalidBookIdException();
        }
    }
