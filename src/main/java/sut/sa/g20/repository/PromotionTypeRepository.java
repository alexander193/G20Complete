package sut.sa.g20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g20.entity.PromotionTypeEntity;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PromotionTypeRepository extends JpaRepository<PromotionTypeEntity, Long> {
    PromotionTypeEntity findByPromotionType(String promotionType);
}
