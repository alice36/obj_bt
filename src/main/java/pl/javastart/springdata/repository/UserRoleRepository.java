package pl.javastart.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.springdata.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
