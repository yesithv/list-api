package yesithv.occupations.services;

import yesithv.exceptions.ListNotFoundException;
import yesithv.occupations.model.OccupationEntity;
import yesithv.occupations.repository.OccupationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static yesithv.exceptions.ErrorCatalog.DONT_FIND_OCCUPATION;
import static yesithv.occupations.mapper.OccupationMapper.OCCUPATION_MAPPER;
import static yesithv.utils.ListType.OCCUPATIONS;

@Slf4j
@Service
@AllArgsConstructor
public class OccupationServiceImpl implements OccupationService {

    private final OccupationRepository occupationRepository;

    @Override
    public List<OccupationEntity> getAllOccupations() {
        log.info("Enter to getAllOccupations");
        var occupationList = occupationRepository.findByEnable(Boolean.TRUE);
        log.info("Found {} occupations", occupationList.size());
        return occupationList;
    }

    @Override
    public OccupationEntity getOccupationById(UUID idOccupation) {
        log.info("Enter to getOccupationById. idOccupation: {}", idOccupation);
        var occupation = occupationRepository.findById(idOccupation).orElseThrow(() -> new ListNotFoundException(String.format(DONT_FIND_OCCUPATION.getDescription(), idOccupation), DONT_FIND_OCCUPATION.getCode(), OCCUPATIONS));
        log.info("Occupation found ? {}", occupation != null); //TODO: validate
        return occupation;
    }

    @Override
    public OccupationEntity saveOccupation(OccupationEntity newOccupation) {
        log.info("Enter to saveOccupation. newOccupation: {}", newOccupation);
        var occupation = occupationRepository.save(newOccupation);
        log.info("Occupation saved ? {}", occupation != null); //TODO: validate
        return occupation;
    }

    @Override
    public OccupationEntity updateOccupation(UUID idOccupation, OccupationEntity newOccupation) {
        log.info("Enter to updateOccupation. oldIdOccupation: {}, newOccupation: {}", idOccupation, newOccupation);
        var oldOccupation = occupationRepository.findById(idOccupation).orElseThrow(() -> new ListNotFoundException(String.format(DONT_FIND_OCCUPATION.getDescription(), idOccupation), DONT_FIND_OCCUPATION.getCode(), OCCUPATIONS));
        log.info("Old occupation found ? {}", oldOccupation != null); //TODO: validate
        var updatedOccupation = occupationRepository.save(OCCUPATION_MAPPER.updateOccupation(oldOccupation, newOccupation));
        log.info("Occupation updated ? {}", updatedOccupation != null); //TODO: Validate
        return updatedOccupation;
    }

    @Override
    public void deleteOccupation(UUID idOccupation) {
        log.info("Enter to deleteOccupation. idOccupation: {}", idOccupation);
        if (!occupationRepository.existsById(idOccupation)) {
            log.error("Occupation with id: {} doesn't exists, so It can't be deleted", idOccupation);
            throw new ListNotFoundException(String.format(DONT_FIND_OCCUPATION.getDescription(), idOccupation), DONT_FIND_OCCUPATION.getCode(), OCCUPATIONS);
        }
        occupationRepository.deleteById(idOccupation);
        log.info("Occupation deleted");
    }

}
