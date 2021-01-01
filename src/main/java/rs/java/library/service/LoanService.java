package rs.java.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.java.library.model.Loan;
import rs.java.library.repository.LoanRepository;

import java.util.List;

@Service
public class LoanService {

    LoanRepository loanRepository;
    PersonService personService;
    BookService bookService;

    @Autowired
    public LoanService(LoanRepository loanRepository,
                       PersonService personService,
                       BookService bookService) {
        this.loanRepository = loanRepository;
        this.personService = personService;
        this.bookService = bookService;
    }

    public Loan addLoan(Loan loan) {
        Loan loanApi = new Loan();
        loanApi.setLoanDate(loan.getLoanDate());
        loanApi.setPerson(personService.getById(loan.getPerson().getId()));

        return loanRepository.save(loanApi);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
