package sut.sa.g20.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "typepayment")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter @Setter
public class TypepaymentEntity {
    @Id
    @SequenceGenerator(name = "type_seq",sequenceName = "type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "type_seq")
    @Column(name = "type_id",unique = true, nullable = false)
    private @NonNull Long typeid;
    private @NonNull String typename;


    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long type_id) {
        this.typeid = type_id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String type_name) {
        this.typename = type_name;
    }
}
