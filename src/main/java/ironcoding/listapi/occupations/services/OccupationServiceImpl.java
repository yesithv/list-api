package ironcoding.listapi.occupations.services;

import ironcoding.listapi.occupations.exception.OccupationNotFoundException;
import ironcoding.listapi.occupations.model.OccupationEntity;
import ironcoding.listapi.occupations.repository.OccupationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static ironcoding.listapi.occupations.mapper.OccupationMapper.OCCUPATION_MAPPER;

@Slf4j
@Service
@AllArgsConstructor
public class OccupationServiceImpl implements OccupationService {

    private final OccupationRepository occupationRepository;

    @Override
    public OccupationEntity saveOccupation(OccupationEntity newOccupation) {
        log.info("Enter to saveOccupation(). newOccupation: [{}]", newOccupation);
        return occupationRepository.save(newOccupation);
    }

    @Override
    public OccupationEntity updateOccupation(UUID idOccupation, OccupationEntity newOccupation) {
        log.info("Enter to updateOccupation(). oldIdOccupation: [{}], newOccupation: [{}]", idOccupation, newOccupation);
        var oldOccupation = occupationRepository.findById(idOccupation).orElseThrow(() -> new OccupationNotFoundException("La ocupación con id [" + idOccupation + "] no existe"));
        return occupationRepository.save(OCCUPATION_MAPPER.updateOccupation(oldOccupation, newOccupation));
    }

    @Override
    public void deleteOccupation(UUID idOccupation) {
        log.info("Enter to deleteOccupation() idOccupation: [{}]", idOccupation);
        if (!occupationRepository.existsById(idOccupation)) {
            log.error("La ocupación con el id [{}] no existe", idOccupation);
            throw new OccupationNotFoundException("La ocupacion con el id [" + idOccupation + "] no existe");
        }
        occupationRepository.deleteById(idOccupation);
    }

    @Override
    public OccupationEntity findOccupationById(UUID idOccupation) {
        log.info("Enter to findOccupationById. idOccupation: [{}]", idOccupation);
        return occupationRepository.findById(idOccupation).orElseThrow(() -> new OccupationNotFoundException("La ocupación con id [" + idOccupation + "] no existe"));
    }

    @Override
    public List<OccupationEntity> findAllOccupations() {
        log.info("Enter to findAllOccupations");
        return occupationRepository.findByEnable(Boolean.TRUE);
    }
}
