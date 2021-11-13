package dk.cb.LoanGateway.repository;


import dk.cb.LoanGateway.model.LoanQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoanQuotesRepository extends JpaRepository<LoanQuote, UUID> {

    List<LoanQuote> findByBorrowerId(UUID id);

    @Modifying
    @Transactional
    @Query("delete from LoanQuote l where l.borrowerId = :id")
    void deleteByBorrowerId(@Param("id") UUID id);


}
