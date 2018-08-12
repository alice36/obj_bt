package pl.javastart.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository  extends JpaRepository<Resident, Long> {
    @Query("SELECT r from Resident r " +
            "where r.id = :letter")
    Resident findResidentUsingId(@Param("letter") Long id);
}
