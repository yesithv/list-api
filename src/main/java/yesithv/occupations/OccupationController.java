package yesithv.occupations;

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
import yesithv.occupations.model.OccupationCollection;
import yesithv.occupations.services.OccupationService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("list-api/v1/occupations")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OccupationController {

    private final OccupationService occupationService;

    @GetMapping()
    public List<OccupationCollection> showAllOccupations() {
        return occupationService.getAllOccupations();
    }

    @GetMapping("/{idOccupation}")
    public OccupationCollection showById(@PathVariable UUID idOccupation) {
        return occupationService.getOccupationById(idOccupation);
    }

    @PostMapping()
    public OccupationCollection create(@RequestBody OccupationCollection occupation) {
        return occupationService.saveOccupation(occupation);
    }

    @PutMapping("/{idOccupation}")
    public OccupationCollection update(@PathVariable UUID idOccupation, @RequestBody OccupationCollection occupation) {
        return occupationService.updateOccupation(idOccupation, occupation);
    }

    @DeleteMapping("/{idOccupation}")
    public void delete(@PathVariable UUID idOccupation) {
        occupationService.deleteOccupation(idOccupation);
    }
}
