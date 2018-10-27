package sut.sa.g20.entity;
import javax.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ROOMTYPE")
public class RoomTypeEntity {
    @Id
    @SequenceGenerator(name="roomtype_seq",sequenceName="roomtype_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roomtype_seq")
    @Column(name="ROOMTYPE_ID",unique = true, nullable = false)
    private @NonNull Long roomTypeId;
    private @NonNull String roomType;
    private @NonNull String bedType;
    private @NonNull int numberOfBed;
    private @NonNull int maxPeople;

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
}
