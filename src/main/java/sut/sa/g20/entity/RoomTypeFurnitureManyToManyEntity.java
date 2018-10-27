package sut.sa.g20.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TableRoomTypeFurniture")
public class RoomTypeFurnitureManyToManyEntity {
    @Id
    @SequenceGenerator(name="roomtypeFurniture_seq",sequenceName="roomtypeFurniture_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roomtypeFurniture_seq")  
    @Column(name="roomtypeFurnitureId",unique = true, nullable = false)
    private long roomtypeFurnitureId;

    //Many To One With RoomTypeEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomTypeEntity.class)
    @JoinColumn(name = "roomtypeId")
    private RoomTypeEntity roomtypeFurnitureMany;

    //Many To One with FurnitureEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = FurnitureEntity.class)
    @JoinColumn(name = "furnitureId")
    private FurnitureEntity furnitureFurnitureRoomTypeMany;

    public RoomTypeFurnitureManyToManyEntity(){}
    public RoomTypeFurnitureManyToManyEntity(FurnitureEntity furnitureFurnitureRoomTypeMany, RoomTypeEntity roomtypeFurnitureMany){
        this.roomtypeFurnitureMany = roomtypeFurnitureMany;
        this.furnitureFurnitureRoomTypeMany = furnitureFurnitureRoomTypeMany;
    }

    public long getRoomtypeFurnitureId() {
        return roomtypeFurnitureId;
    }
    public void setRoomtypeFurnitureId(long roomtypeFurnitureId) {
        this.roomtypeFurnitureId = roomtypeFurnitureId;
    }
    public RoomTypeEntity getRoomtypeFurnitureMany() {
        return roomtypeFurnitureMany;
    }
    public void setRoomtypeFurnitureMany(RoomTypeEntity roomtypeFurnitureMany) {
        this.roomtypeFurnitureMany = roomtypeFurnitureMany;
    }
    public FurnitureEntity getFurnitureFurnitureRoomTypeManyMany() {
        return furnitureFurnitureRoomTypeMany;
    }
    public void setFurnitureFurnitureRoomTypeManyMany(FurnitureEntity furnitureFurnitureRoomTypeMany) {
        this.furnitureFurnitureRoomTypeMany = furnitureFurnitureRoomTypeMany;
    }

}
