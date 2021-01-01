package rs.java.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.java.library.mapper.BookMapper;
import rs.java.library.repository.BookRepository;
import rs.java.library.request.BookRequest;
import rs.java.library.response.BookResponse;

import java.util.Set;
import java.util.stream.Collectors;

import static rs.java.library.mapper.BookMapper.mapToEntity;
import static rs.java.library.mapper.BookMapper.mapToResponse;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Integer addBook(BookRequest request) {
        return bookRepository.save(mapToEntity(request)).getId();
    }

    public BookResponse getById(Integer id) {
        return mapToResponse(bookRepository.findById(id).orElseThrow(() -> new RuntimeException("INVALID BOOK ID NUMBER: " + id)));
    }

    public Set<BookResponse> getAll() {
        return bookRepository.findAll().stream()
                .map(BookMapper::mapToResponse)
                .collect(Collectors.toSet());
    }
}
