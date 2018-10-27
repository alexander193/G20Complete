package sut.sa.g20.repository;

import sut.sa.g20.entity.StatusPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface StatusPaymentRepository extends JpaRepository<StatusPaymentEntity, Long> {
    @Query("SELECT t FROM StatusPaymentEntity t WHERE t.status = :status")
    StatusPaymentEntity findByName(@Param("status") String status);
}