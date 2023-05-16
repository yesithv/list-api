package ironcoding.listapi.occupations.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("list-api/v1/occupations")
public class OccupationResource {

    @GetMapping()
    public String getOccupations() {
        return "Hola ocupacionssss";
    }


}
