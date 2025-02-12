package yesithv.occupations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import yesithv.occupations.model.OccupationEntity;

import java.util.List;
import java.util.UUID;

public interface OccupationRepository extends MongoRepository<OccupationEntity, UUID> {

    List<OccupationEntity> findByEnable(boolean enable);
}
