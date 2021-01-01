package rs.java.library.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rs.java.library.model.BookEntity;
import rs.java.library.model.Person;
import rs.java.library.model.Sex;
import rs.java.library.repository.BookRepository;
import rs.java.library.service.BookService;
import rs.java.library.service.PersonService;

@Component
public class LoanData implements CommandLineRunner {

    private PersonService personService;
    private BookService bookService;
    private BookRepository bookRepository;

    @Autowired
    public LoanData(PersonService personService,
                    BookService bookService,
                    BookRepository bookRepository) {
        this.personService = personService;
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Person person = new Person("Margott", "Robbie", Sex.FEMALE);
        Person person2 = new Person("Mariusz", "Budzianowski", Sex.MALE);
        Person person3 = new Person("Sławek", "Toczek", Sex.MALE);
        Person person4 = new Person("Andrzej", "Golota", Sex.MALE);
        Person person5 = new Person("Paris", "Hilton", Sex.FEMALE);
        Person person6 = new Person("Nicole", "Kidman", Sex.FEMALE);

        personService.addPerson(person);
        personService.addPerson(person2);
        personService.addPerson(person3);
        personService.addPerson(person4);
        personService.addPerson(person5);
        personService.addPerson(person6);

        BookEntity bookEntity = new BookEntity("963852741", "Best Cars", "Jeremy Clarkson");
        BookEntity bookEntity2 = new BookEntity("123456789", "JW Construction", "Highest Buildings");
        BookEntity bookEntity3 = new BookEntity("741852963", "Adam Mickiewicz", "Pan Tadeusz");
        BookEntity bookEntity4 = new BookEntity("7539512864", "Scott Gallawy", "The four");
        BookEntity bookEntity5 = new BookEntity("789987789", "Michal Makaruk", "Java first steps");
        BookEntity bookEntity6 = new BookEntity("123321123", "Mario Bross", "Super Mario");

        bookRepository.save(bookEntity);
        bookRepository.save(bookEntity2);
        bookRepository.save(bookEntity3);
        bookRepository.save(bookEntity4);
        bookRepository.save(bookEntity5);
        bookRepository.save(bookEntity6);
    }
}
