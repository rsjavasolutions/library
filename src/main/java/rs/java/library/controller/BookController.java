package rs.java.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.java.library.model.Book;
import rs.java.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getAll();
    }

}
