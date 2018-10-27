package sut.sa.g20.entity;

import lombok.*;


import javax.persistence.*;

@Data
@Entity
@Table(name = "payment")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter @Setter
public class PaymentEntity {
    @Id
    @SequenceGenerator(name = "bill_seq",sequenceName = "bill_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bill_seq")
    @Column(name = "billid",unique = true, nullable = false)
    private @NonNull Long billid;
    private @NonNull String name;
    private @NonNull String lastname;
    private @NonNull String address;
    private @NonNull int phonenum;
  
    //many-to-one  with accountbank
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = AccountbankEntity.class)
    private AccountbankEntity accountbankEntity;

    

    //one-to-one with billreserve
    @OneToOne(fetch = FetchType.EAGER,targetEntity = ReservationsEntity.class)
    private ReservationsEntity reservation;

    

    //many-to-one with typepayment
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = TypepaymentEntity.class)
    private TypepaymentEntity typepayments;
    
    //many-to-one with customer
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = CustomerEntity.class)
    private CustomerEntity customerEntity;

    public AccountbankEntity getAccountbankEntity() {
        return this.accountbankEntity;
    }

    public void setAccountbankEntity(AccountbankEntity accountbankEntity) {
        this.accountbankEntity = accountbankEntity;
    }
    public ReservationsEntity getReservation() {
        return this.reservation;
    }

    public void setReservation(ReservationsEntity reservation) {
        this.reservation = reservation;
    }

   

    public TypepaymentEntity getTypepayments() {
        return this.typepayments;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
    public CustomerEntity getCustomerEntity() {
        return this.customerEntity;
    }

    public void setTypepayments(TypepaymentEntity typepayments) {
        this.typepayments = typepayments;
    }
    public Long getBillid() {
        return billid;
    }


    public void setBillid(Long bill_id) {
        this.billid = bill_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(int phone_num) {
        this.phonenum = phone_num;
    }

    
}
