package rs.java.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rs.java.library.request.BookRequest;
import rs.java.library.response.BookResponse;
import rs.java.library.service.BookService;

import java.util.Set;

@RestController
@RequestMapping("api/books")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer addBook(@RequestBody BookRequest request) {
        return bookService.addBook(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<BookResponse> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getBookByID(@PathVariable Integer id) {
        return bookService.getById(id);
    }
}
