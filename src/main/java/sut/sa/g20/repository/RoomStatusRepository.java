package sut.sa.g20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g20.entity.RoomStatusEntity;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RoomStatusRepository extends JpaRepository<RoomStatusEntity, Long> {
    RoomStatusEntity findByroomStatus(String roomStatus);

    @Query("SELECT t FROM RoomStatusEntity t WHERE t.roomStatus = :Name")
    RoomStatusEntity findByName(@Param("Name")String Name);
}
