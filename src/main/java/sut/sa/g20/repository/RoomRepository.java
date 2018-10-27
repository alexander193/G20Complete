package sut.sa.g20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g20.entity.HotelEntity;
import sut.sa.g20.entity.RoomEntity;
import sut.sa.g20.entity.RoomTypeEntity;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    Collection<RoomEntity> findByhotelEntity(HotelEntity hotelEntity);
    Collection<RoomEntity> findByhotelEntityAndRoomTypeEntity(HotelEntity hotelEntity, RoomTypeEntity roomTypeEntity);
    @Query("SELECT t.roomNumber FROM RoomEntity t WHERE t.roomNumber = :Name")
    Integer findByRoomNumber(@Param("Name")int Name);

    @Query("SELECT t.hotelEntity.hotelId FROM RoomEntity t WHERE t.hotelEntity.hotelId = :id and t.roomNumber = :roomNumber")
    Long findByHotelId(@Param("id")Long id,@Param("roomNumber")int roomNumber);

    @Query("SELECT t FROM RoomEntity t WHERE t.hotelEntity.hotelId = :hotelid and t.roomTypeEntity.roomTypeId = :roomtypeid and t.roomStatusEntity.roomStatusId = :roomstatusId")
    Collection<RoomEntity> findRoomByHotelIdRoomTypeId(@Param("hotelid")long hotelid,@Param("roomtypeid")long roomtypeid,@Param("roomstatusId")long roomstatusId);

    @Query("SELECT t.roomPrice FROM RoomEntity t WHERE t.roomId = :Name")
    int findRoomPriceById(@Param("Name")long Name);
}
