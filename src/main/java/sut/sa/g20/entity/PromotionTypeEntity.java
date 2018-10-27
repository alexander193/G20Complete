package sut.sa.g20.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "PROMOTIONTYPE")
public class PromotionTypeEntity {
    @Id
    @SequenceGenerator(name="promotiontype_seq",sequenceName="promotiontype_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="promotiontype_seq")
    @Column(name="PROMOTIONTYPE_ID",unique = true, nullable = false)
    private @NonNull Long promotionTypeId;
    private @NonNull String promotionType;

    public Long getPromotionTypeId() {
        return promotionTypeId;
    }

    public void setPromotionTypeId(Long promotionTypeId) {
        this.promotionTypeId = promotionTypeId;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }
}
