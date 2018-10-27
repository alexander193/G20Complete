package sut.sa.g20.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ROOM")
public class RoomEntity {
    @Id
    @SequenceGenerator(name="hotelroom_seq",sequenceName="hotelroom_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hotelroom_seq")
    @Column(name="ROOM_ID",unique = true, nullable = false)
    private @NonNull Long roomId;
    private @NonNull int roomNumber;
    private @NonNull int roomPrice;
    private String roomImg;

    //Many To One with HotelEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = HotelEntity.class)
    private HotelEntity hotelEntity;

    //Many To One with RoomTypeEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomTypeEntity.class)
    private RoomTypeEntity roomTypeEntity;

    //Many To One with RoomStatusEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomStatusEntity.class)
    private RoomStatusEntity roomStatusEntity;

    public HotelEntity getHotel() {
        return hotelEntity;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotelEntity = hotel;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public RoomTypeEntity getRoomTypeEntity() {
        return roomTypeEntity;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
    }

    public void setRoomTypeEntity(RoomTypeEntity roomTypeEntity) {
        this.roomTypeEntity = roomTypeEntity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public RoomStatusEntity getRoomStatusEntity() {
        return roomStatusEntity;
    }

    public void setRoomStatusEntity(RoomStatusEntity roomStatusEntity) {
        this.roomStatusEntity = roomStatusEntity;
    }
}
