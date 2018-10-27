package sut.sa.g20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g20.entity.HotelEntity;
import sut.sa.g20.entity.PromotionEntity;
import sut.sa.g20.entity.PromotionTypeEntity;
import sut.sa.g20.entity.RoomTypeEntity;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {
    Collection<PromotionEntity> findByhotelEntity(HotelEntity hotelEntity);
    PromotionEntity findBydetail(String detail);
    Collection<PromotionEntity> findByhotelEntityAndRoomTypeEntity(HotelEntity hotelEntity, RoomTypeEntity roomTypeEntity);
        @Query("SELECT t.promotionId FROM PromotionEntity t WHERE t.detail = :name")
    Long findId(@Param("name")String name);

    @Query("SELECT t.discount FROM PromotionEntity t WHERE t.promotionId = :name")
    int findDiscount(@Param("name")long name);
}
