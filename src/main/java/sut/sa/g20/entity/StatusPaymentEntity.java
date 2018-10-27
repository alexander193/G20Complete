package sut.sa.g20.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "statuspay")
@ToString
@EqualsAndHashCode
@Getter @Setter
public class StatusPaymentEntity {
    @Id
    @SequenceGenerator(name = "status_seq",sequenceName = "status_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "status_seq")
    @Column(name = "statusId", unique = true, nullable = false)
    private @NonNull Long statusId;
    private @NonNull String status;
    public StatusPaymentEntity(){

    } 
    public StatusPaymentEntity(String name){
        this.status = name;
    }

    public Long getStatusID() {
        return this.statusId;
    }

    public void setStatusID(Long statusID) {
        this.statusId = statusID;
    }
    

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}