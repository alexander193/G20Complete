package sut.sa.g20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g20.entity.RoomTypeEntity;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Long> {
    RoomTypeEntity findByroomType(String roomType);

    @Query("SELECT t FROM RoomTypeEntity t WHERE t.roomType = :Name")
    RoomTypeEntity findByName(@Param("Name")String Name);
    
    @Query("SELECT t.roomTypeId FROM RoomTypeEntity t WHERE t.roomType = :Name")
    long findIdByName(@Param("Name")String Name);

    @Query("SELECT t FROM RoomTypeEntity t WHERE t.roomType = :Name")
    RoomTypeEntity findRoomTypeByName(@Param("Name")String Name);
    
}
