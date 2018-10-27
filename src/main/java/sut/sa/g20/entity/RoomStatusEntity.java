package sut.sa.g20.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ROOMSTATUS")
public class RoomStatusEntity {
    @Id
    @SequenceGenerator(name="roomstatus_seq",sequenceName="roomstatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roomstatus_seq")
    @Column(name="ROOMSTATUS_ID",unique = true, nullable = false)
    private Long roomStatusId;
    private String roomStatus;

    public Long getRoomStatusId() {
        return roomStatusId;
    }

    public void setRoomStatusId(Long roomStatusId) {
        this.roomStatusId = roomStatusId;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

}
