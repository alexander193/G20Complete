package sut.sa.g20.repository;

import sut.sa.g20.entity.CountryCodeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public
interface CountryCodeRepository extends JpaRepository<CountryCodeEntity, Long> {
          CountryCodeEntity findBycountrycode(String countrycode);
          CountryCodeEntity findBycountrycodeid(Long countrycodeid);
}
