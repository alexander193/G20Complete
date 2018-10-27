package sut.sa.g20.entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Data
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name = "CustomerEntity")
public class CustomerEntity {
  @Id
  @SequenceGenerator(name="customer_seq",sequenceName="customer_seq")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
  @Column(name="customerid",unique = true, nullable = false)
  private @NonNull Long customerid;
  private @NonNull String customername;
  private @NonNull String customeraddress;
  private @NonNull String customeremail;
  private @NonNull String customerphone;
  private @NonNull String customerpass;

  @ManyToOne(fetch=FetchType.EAGER, targetEntity = CountryCodeEntity.class)
  @JoinColumn(name = "countrycodeid")
  private CountryCodeEntity country;

  @ManyToOne(fetch=FetchType.EAGER, targetEntity = SexEntity.class)
  @JoinColumn(name = "sexid")
  private SexEntity sexEntity;

  @ManyToOne(fetch=FetchType.EAGER, targetEntity = TitleNameEntity.class)
  @JoinColumn(name = "titlenameid")
  private TitleNameEntity title;


  public CustomerEntity() {

  }

  public CustomerEntity(String customername, String customeraddress,
                        String customeremail, String customerphone, String customerpass) {
    this.customername = customername;
    this.customeraddress = customeraddress;
    this.customeremail = customeremail;
    this.customerphone = customerphone;
    this.customerpass= customerpass;

  }

  public  void setTitleName(TitleNameEntity ti){
    this.title = ti;
  }

  public TitleNameEntity getTitleName(){
    return this.title;
  }
  public  void setCustomersex(SexEntity sexEntity){
    this.sexEntity = sexEntity;
  }

  public SexEntity getCustomersex(){
    return this.sexEntity;
  }

  public void setCountry(CountryCodeEntity country) {
    this.country = country;
  }

  public CountryCodeEntity getCountry() {
    return this.country;
  }

  public void setCustomerid(Long customerid) {
    this.customerid = customerid;
  }

  public Long getCustomerid() {
    return customerid;
  }

  public void setCustomername(String customername) {
    this.customername = customername;
  }

  public String getCustomername() {
    return customername;
  }

  public void setCustomeraddress(String customeraddress) {
    this.customeraddress = customeraddress;
  }

  public String getCustomeraddress() {
    return customeraddress;
  }

  public void setCustomeremail(String customeremail) {
    this.customeremail = customeremail;
  }

  public String getCustomeremail() {
    return customeremail;
  }

  public void setCustomerphone(String customerphone) {
    this.customerphone = customerphone;
  }

  public String getCustomerphone() {
    return customerphone;
  }

  public void setCustomerpass(String customerpass){this.customerpass = customerpass;}

  public String getCustomerpass() { return customerpass; }
}
