package pl.javastart.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.springdata.model.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
}