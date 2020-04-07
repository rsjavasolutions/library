package rs.java.library.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rs.java.library.model.Book;
import rs.java.library.model.Loan;
import rs.java.library.model.Person;
import rs.java.library.model.Sex;
import rs.java.library.service.BookService;
import rs.java.library.service.LoanService;
import rs.java.library.service.PersonService;

import java.time.LocalDate;

@Component
public class LoanData implements CommandLineRunner {

    private PersonService personService;
    private BookService bookService;

    @Autowired
    public LoanData(PersonService personService, BookService bookService) {
        this.personService = personService;
        this.bookService = bookService;
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

        Book book = new Book("963852741", "Best Cars", "Jeremy Clarkson");
        Book book2 = new Book("123456789", "JW Construction", "Highest Buildings");
        Book book3 = new Book("741852963", "Adam Mickiewicz", "Pan Tadeusz");
        Book book4 = new Book("7539512864", "Scott Gallawy", "The four");
        Book book5 = new Book("789987789", "Michal Makaruk", "Java first steps");
        Book book6 = new Book("123321123", "Mario Bross", "Super Mario");

        bookService.addBook(book);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);
        bookService.addBook(book5);
        bookService.addBook(book6);
    }
}
