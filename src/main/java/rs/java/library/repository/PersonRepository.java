package rs.java.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.java.library.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
