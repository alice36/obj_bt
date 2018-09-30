package pl.javastart.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.javastart.springdata.model.Login;
import pl.javastart.springdata.model.Ticket;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    @Query("SELECT l from Login l " +
            "where l.loginName = :letter")
    Login findLoginUsingName(@Param("letter") String login);
}
