package ironcoding.listapi.occupations.rest;

import ironcoding.listapi.occupations.model.OccupationEntity;
import ironcoding.listapi.occupations.services.OccupationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("list-api/v1/occupations")
@AllArgsConstructor
public class OccupationResource {

    private final OccupationService occupationService;

    @GetMapping()
    public List<OccupationEntity> showAllOccupations() {
        return occupationService.findAllOccupations();
    }

    @GetMapping("/{idOccupation}")
    public OccupationEntity showById(@PathVariable UUID idOccupation) {
        return occupationService.findOccupationById(idOccupation);
    }

    @PostMapping()
    public OccupationEntity create(@RequestBody OccupationEntity occupation) {
        return occupationService.saveOccupation(occupation);
    }

    @PutMapping("/{idOccupation}")
    public OccupationEntity update(@PathVariable UUID idOccupation, @RequestBody OccupationEntity occupation) {
        return occupationService.updateOccupation(idOccupation, occupation);
    }

    @DeleteMapping("/{idOccupation}")
    public void delete(@PathVariable UUID idOccupation) {
        occupationService.deleteOccupation(idOccupation);
    }
}
