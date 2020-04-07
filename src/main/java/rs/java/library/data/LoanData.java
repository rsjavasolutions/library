package rs.java.library.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rs.java.library.model.Book;
import rs.java.library.model.Loan;
import rs.java.library.model.Person;
import rs.java.library.model.Sex;
import rs.java.library.service.LoanService;

import java.time.LocalDate;

@Component
public class LoanData implements CommandLineRunner {

    LoanService loanService;

    @Autowired
    public LoanData(LoanService loanService) {
        this.loanService = loanService;
    }

    @Override
    public void run(String... args) throws Exception {

        Person person = new Person("Margott","Robbie", Sex.FEMALE);
        Book book = new Book("963852741","Best Cars", "Jeremy Clarkson");
        Loan loan = new Loan();
        loan.setLoanDate(LocalDate.now());
        loan.setBook(book);
        loan.setPerson(person);

       // loanService.addLoan(loan);

    }
}
