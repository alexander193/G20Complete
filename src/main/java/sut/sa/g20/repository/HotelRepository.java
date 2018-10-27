package sut.sa.g20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g20.entity.HotelEntity;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    HotelEntity findByhotelNameEng(String hotelNameEng);

    @Query("SELECT t FROM HotelEntity t WHERE t.hotelNameEng = :Name")
    HotelEntity findByName(@Param("Name")String Name);

    @Query("SELECT t.hotelId FROM HotelEntity t WHERE t.hotelNameEng = :Name")
    Long findByHotelName(@Param("Name")String Name);

    @Query("SELECT t FROM HotelEntity t WHERE t.memberHotel.memberHotelId  = :id")
    HotelEntity findHotelByMemberId(@Param("id")Long id);

    @Query("SELECT t.hotelId FROM HotelEntity t WHERE t.memberHotel.memberHotelId = :id")
    Long findHotelIdByMemId(@Param("id")Long id);

    @Query("SELECT t FROM HotelEntity t WHERE t.provinceEntity.provinceId = :Name")
    Collection<HotelEntity> findHotelByProvinceId(@Param("Name") long provinceId);

    @Query("SELECT t.provinceEntity.provinceId FROM HotelEntity t WHERE t.hotelId = :hotelId")
    Long findProvinceIdByHotelId(@Param("hotelId") long hotelId);

}
