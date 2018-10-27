package sut.sa.g20.repository;

import sut.sa.g20.entity.TitleNameEntity;

  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.data.rest.core.annotation.RepositoryRestResource;
  import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public
interface TitleNameRepository extends JpaRepository<TitleNameEntity, Long> {
  TitleNameEntity findBytitlename(String titlename);
}
