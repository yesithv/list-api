package yesithv.occupations.services;

import yesithv.occupations.model.OccupationCollection;

import java.util.List;
import java.util.UUID;

public interface OccupationService {

    List<OccupationCollection> getAllOccupations();

    OccupationCollection getOccupationById(UUID idOccupation);

    OccupationCollection saveOccupation(OccupationCollection newOccupation);

    OccupationCollection updateOccupation(UUID oldIdOccupation, OccupationCollection newOccupation);

    void deleteOccupation(UUID idOccupation);
}
