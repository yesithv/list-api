package yesithv.occupations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import yesithv.occupations.model.OccupationCollection;

import java.util.List;
import java.util.UUID;

public interface OccupationRepository extends MongoRepository<OccupationCollection, UUID> {

    List<OccupationCollection> findByEnable(boolean enable);
}
