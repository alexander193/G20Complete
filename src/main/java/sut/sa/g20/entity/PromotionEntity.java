package sut.sa.g20.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "PROMOTION")
public class PromotionEntity {
    @Id
    @SequenceGenerator(name="promotion_seq",sequenceName="promotion_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="promotion_seq")
    @Column(name="PROMOTION_ID",unique = true, nullable = false)
    private @NonNull Long promotionId;
    private int discount;
    private @NonNull Date dateStart;
    private @NonNull Date dateEnd;
    private String detail;

    //Many To One with HotelEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = HotelEntity.class)
    private HotelEntity hotelEntity;

    //Many To One with PromotionTypeEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PromotionTypeEntity.class)
    private PromotionTypeEntity promotionTypeEntity;

    //Many To One with RoomTypeEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomTypeEntity.class)
    private RoomTypeEntity roomTypeEntity;

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    public PromotionTypeEntity getPromotionTypeEntity() {
        return promotionTypeEntity;
    }

    public void setPromotionTypeEntity(PromotionTypeEntity promotionTypeEntity) {
        this.promotionTypeEntity = promotionTypeEntity;
    }

    public RoomTypeEntity getRoomTypeEntity() {
        return roomTypeEntity;
    }

    public void setRoomTypeEntity(RoomTypeEntity roomTypeEntity) {
        this.roomTypeEntity = roomTypeEntity;
    }
}
