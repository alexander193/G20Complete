package sut.sa.g20.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g20.entity.ReservationsEntity;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public
interface ReservationsRepository extends JpaRepository<ReservationsEntity, Long> {
    ReservationsEntity findByReservationsId(Long reservationsid);
    
    @Query("SELECT t FROM ReservationsEntity t WHERE t.Customertype.customerid = :id AND t.statusPaymentEntity.status = :status")
    Collection<ReservationsEntity> findReservationByCustomerId(@Param("id") Long id,@Param("status")String status);
    
}