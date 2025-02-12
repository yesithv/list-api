package yesithv.occupations.services;

import yesithv.occupations.model.OccupationEntity;

import java.util.List;
import java.util.UUID;

public interface OccupationService {

    List<OccupationEntity> getAllOccupations();

    OccupationEntity getOccupationById(UUID idOccupation);

    OccupationEntity saveOccupation(OccupationEntity newOccupation);

    OccupationEntity updateOccupation(UUID oldIdOccupation, OccupationEntity newOccupation);

    void deleteOccupation(UUID idOccupation);
}
