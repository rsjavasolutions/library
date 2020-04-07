package rs.java.library.controller;

import org.aspectj.lang.annotation.DeclareWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.java.library.model.Loan;
import rs.java.library.service.LoanService;

@RestController
@RequestMapping("/api/")
public class LoanController {

    LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("loans")
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.addLoan(loan);
    }
}
