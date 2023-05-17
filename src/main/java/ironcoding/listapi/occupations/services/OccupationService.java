package ironcoding.listapi.occupations.services;

import ironcoding.listapi.occupations.model.OccupationEntity;

import java.util.List;
import java.util.UUID;

public interface OccupationService {

    OccupationEntity saveOccupation(OccupationEntity newOccupation);

    OccupationEntity updateOccupation(UUID oldIdOccupation, OccupationEntity newOccupation);

    void deleteOccupation(UUID idOccupation);

    OccupationEntity findOccupationById(UUID idOccupation);

    List<OccupationEntity> findAllOccupations();
}
