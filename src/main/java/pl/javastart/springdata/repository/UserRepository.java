package pl.javastart.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.springdata.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
