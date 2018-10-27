package sut.sa.g20.entity;
import javax.persistence.Entity;
import java.util.List;
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
@Table(name = "TitleNameEntity")
public class TitleNameEntity {
  @Id
  @SequenceGenerator(name="titleName_seq",sequenceName="titleName_seq")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="titleName_seq")
  @Column(name="titlenameid",unique = true, nullable = false)
  private @NonNull Long titlenameid;
  private @NonNull String titlename;

  public TitleNameEntity() {

  }

  public TitleNameEntity(String titlename) {
    this.titlename = titlename;


  }

  public void setTitlenameid(Long titlenameid) {
    this.titlenameid = titlenameid;
  }

  public Long getTitlenameid() {
    return titlenameid;
  }

  public void setTitlename(String titlename) {
    this.titlename = titlename;
  }

  public String getTitlename() {
    return titlename;
  }

}
