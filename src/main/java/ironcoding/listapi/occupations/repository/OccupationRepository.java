package ironcoding.listapi.occupations.repository;

import ironcoding.listapi.occupations.model.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OccupationRepository extends JpaRepository<OccupationEntity, UUID> {

    List<OccupationEntity> findByEnable(boolean enable);
}
