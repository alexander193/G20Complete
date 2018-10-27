package sut.sa.g20.entity;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Table(name = "bank")
@ToString
@EqualsAndHashCode
@Getter @Setter
public class BankEntity {
    @Id
    @SequenceGenerator(name = "bank_seq",sequenceName = "bank_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bank_seq")
    @Column(name = "bankid",unique = true, nullable = false)
    private @NonNull Long  bankid;
    private @NonNull String bankname;
    

    
    public Long getBankid() {
        return bankid;
    }

    public void setBankid(Long bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }
    public BankEntity(){}
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
}
