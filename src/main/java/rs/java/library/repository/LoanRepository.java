package rs.java.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.java.library.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{
}
