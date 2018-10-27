package sut.sa.g20.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Entity //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter
@NoArgsConstructor
@Table(name="Reservations") //ชื่อตาราง
public class ReservationsEntity {

    @Id
    @SequenceGenerator(name="reservations_seq",sequenceName="reservations_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reservations_seq")
    @Column(name="reservationsId",unique = true, nullable = false)
private Long reservationsId;
    private Date dateStart;

private Date dateEnd;
private int numberOfPeople;
private int numberOfRoom;
private int totalPrice;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CustomerEntity.class)
    @JoinColumn(name= "customerid")
    private CustomerEntity Customertype;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomTypeEntity.class)
    @JoinColumn(name= "roomTypeId")
    private RoomTypeEntity roomTypeEntity;

    public int getRoomPrice() {
        return totalPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.totalPrice = roomPrice;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = HotelEntity.class)
    @JoinColumn(name= "hotelId")
    private HotelEntity Hoteltype;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = StatusPaymentEntity.class)
    @JoinColumn(name= "statusId")
    private StatusPaymentEntity statusPaymentEntity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PromotionEntity.class)
    @JoinColumn(name= "PromotionId")
    private PromotionEntity Promotiontype;

    public Long getReservationsId() {
        return reservationsId;
    }

    public void setReservationsId(Long reservationsId) {
        this.reservationsId = reservationsId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public RoomTypeEntity getRoomTypeEntity() {
        return roomTypeEntity;
    }

    public void setRoomTypeEntity(RoomTypeEntity roomTypeEntity) {
        this.roomTypeEntity = roomTypeEntity;
    }

    public CustomerEntity getCustomertype() {
        return Customertype;
    }

    public void setCustomertype(CustomerEntity customertype) {
        Customertype = customertype;
    }
    public StatusPaymentEntity getStatusPaymentEntity() {
        return statusPaymentEntity;
    }

    public void setStatusPaymentEntity(StatusPaymentEntity statusPaymentEntity) {
        this.statusPaymentEntity = statusPaymentEntity;
    }
    public HotelEntity getHoteltype() {
        return Hoteltype;
    }

    public void setHoteltype(HotelEntity hoteltype) {
        Hoteltype = hoteltype;
    }

    public PromotionEntity getPromotiontype() {
        return Promotiontype;
    }

    public void setPromotion(PromotionEntity promotiontype) {
        Promotiontype = promotiontype;
    }
}



