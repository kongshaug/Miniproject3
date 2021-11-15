package dk.cb.bank1.repository;

import dk.cb.bank1.model.Borrower;
import dk.cb.bank1.model.LoanQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, UUID> {
}
