package pl.javastart.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.javastart.springdata.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t from Ticket t " +
            "where t.voucher.id = :letter")
    Ticket findTicketUsingId(@Param("letter") Long id);

    @Query("SELECT t from Ticket t " +
            "where t.voucher.numer = :letter")
    Ticket findTicketUsingNumer(@Param("letter") String numer);
}
