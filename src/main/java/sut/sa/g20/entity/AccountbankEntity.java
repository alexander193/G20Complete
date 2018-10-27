package sut.sa.g20.entity;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Table(name = "AccountbankEntity")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter @Setter
public class AccountbankEntity {
    @Id
    @SequenceGenerator(name = "account_seq",sequenceName = "account_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "account_seq")
    @Column(name = "account_id",unique = true, nullable = false)
    private @NonNull Long accountID;
    private @NonNull String accountNumber;

    
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = BankEntity.class)
    private BankEntity bank;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAccountID() {
        return this.accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }
    public void setBankEntity(BankEntity bankEntity){
        this.bank = bankEntity;
    }
    public BankEntity getBankEntity(){
        return this.bank;
    }

}