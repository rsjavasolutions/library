package rs.java.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.java.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
