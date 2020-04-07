package rs.java.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.java.library.model.Loan;
import rs.java.library.repository.BookRepository;
import rs.java.library.repository.LoanRepository;
import rs.java.library.repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    LoanRepository loanRepository;
    PersonRepository personRepository;
    BookRepository bookRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository,
                       PersonRepository personRepository,
                       BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
    }

    public Loan addLoan(Loan loan) {
        Loan loanApi = new Loan();
        loanApi.setLoanDate(loan.getLoanDate());
        loanApi.setPerson(personRepository.findById(loan.getPerson().getId()).get());
        loanApi.setBook(bookRepository.findById(loan.getBook().getId()).get());

        return loanRepository.save(loanApi);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
