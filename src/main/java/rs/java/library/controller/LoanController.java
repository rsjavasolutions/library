package rs.java.library.controller;

import org.aspectj.lang.annotation.DeclareWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.java.library.model.Loan;
import rs.java.library.service.LoanService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class LoanController {

    LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("loans")
    public List<Loan> getAllLoans(){
        return loanService.getAllLoans();
    }

    @PostMapping("loans")
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.addLoan(loan);
    }
}
