package sut.sa.g20.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sut.sa.g20.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
    @Query("SELECT t FROM PaymentEntity t WHERE t.name = :billName")
    PaymentEntity findByBillName(@Param("billName") String billName);

    @Query("SELECT t FROM PaymentEntity t WHERE t.billid = :x")
    PaymentEntity findBillById(@Param("x") Long x);
}
