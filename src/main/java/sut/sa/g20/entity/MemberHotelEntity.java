
package sut.sa.g20.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table (name = "TableMemberHotel")
public class MemberHotelEntity {
    @Id
    @SequenceGenerator(name="memberHotel_seq",sequenceName="memberHotel_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="memberHotel_seq")
    @Column(name="memberHotelId",unique = true, nullable = false)
    private @NonNull Long memberHotelId;
    private String  memberHotelName;
    private Long  memberHotelPassword;

    public MemberHotelEntity(){ }
    public MemberHotelEntity(String memberHotelName, Long memberHotelPassword){
        this.memberHotelName = memberHotelName;
        this.memberHotelPassword = memberHotelPassword;
    }
    public void setMemberHotelName(String memberHotelName){
        this.memberHotelName = memberHotelName;
    }
    public String getMemberHotelName(){
        return this.memberHotelName = memberHotelName;
    }
    public void setMemberHotelPassword(Long memberHotelPassword){
        this.memberHotelPassword = memberHotelPassword;
    }
    public Long getMemberHotelPassword(){
        return this.memberHotelPassword = memberHotelPassword;
    }
}
