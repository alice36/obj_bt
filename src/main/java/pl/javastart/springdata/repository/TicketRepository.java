package pl.javastart.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.springdata.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
