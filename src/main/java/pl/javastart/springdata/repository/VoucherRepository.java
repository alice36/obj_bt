package pl.javastart.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.javastart.springdata.model.Ticket;
import pl.javastart.springdata.model.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    @Query(value="SELECT * from Voucher v " +
            "where v.is_available = 1  LIMIT 1", nativeQuery = true)
    Voucher findFirstFreeVoucher();

    @Query("SELECT v from Voucher v " +
            "where v.numer = :letter")
    Voucher findVoucherUsingNumber(@Param("letter") String numer);
}