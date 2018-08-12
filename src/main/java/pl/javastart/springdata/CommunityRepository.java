package pl.javastart.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
    Community findByName(String name);
    @Query("SELECT c from Community c " +
            "where c.id = :letter")
    Community findCommunityUsingId(@Param("letter") Long id);
}
