package pl.javastart.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.javastart.springdata.model.Ticket;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t from Ticket t " +
            "where t.voucher.id = :letter")
    Ticket findTicketUsingId(@Param("letter") Long id);

    @Query("SELECT t from Ticket t " +
            "where t.voucher.numer = :letter")
    Ticket findTicketUsingNumer(@Param("letter") String numer);

    @Query("SELECT t from Ticket t " +
            "where t.login = :letter")
    List<Ticket> findTicketUsingLogin(@Param("letter") String login);

//    @Query("SELECT count(t) from Ticket t " +
//            "where t.login = :letter and t.bookingDate = :tmp")
//    Long countTicketUsingLoginAndDate(@Param("letter") String login, LocalDate tmp);

    @Query("SELECT count(t) from Ticket t " +
            "where t.login = :letter")
    Long countTicketUsingLoginAndDate(@Param("letter") String login);

}
