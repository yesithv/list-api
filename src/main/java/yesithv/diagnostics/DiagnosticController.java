package yesithv.diagnostics;

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
import yesithv.diagnostics.model.DiagnosticEntity;
import yesithv.diagnostics.model.DiagnosticType;
import yesithv.diagnostics.services.DiagnosticServices;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("list-api/v1/diagnostics")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DiagnosticController {

    private final DiagnosticServices diagnosticServices;

    @GetMapping("/{}") //TODO: Put the correct paramether
    public List<DiagnosticEntity> showDiagnosticsByType(DiagnosticType diagnosticType) {
        return diagnosticServices.getAllDiagnosticsByType(diagnosticType);
    }

    @GetMapping("/{idDiagnostic}")
    public DiagnosticEntity showById(@PathVariable UUID idDiagnostic) {
        return diagnosticServices.getDiagnosticById(idDiagnostic);
    }

    @PostMapping
    public DiagnosticEntity create(@RequestBody DiagnosticEntity diagnostic) {
        return diagnosticServices.saveDiagnostic(diagnostic);
    }

    @PutMapping("/{idDiagnostic}")
    public DiagnosticEntity update(@PathVariable UUID idDiagnostic, @RequestBody DiagnosticEntity diagnostic) {
        return diagnosticServices.updateDiagnostic(idDiagnostic, diagnostic);
    }

    @DeleteMapping("/{idDiagnostic}")
    public void delete(@PathVariable UUID idDiagnostic) {
        diagnosticServices.deleteDiagnostic(idDiagnostic);
    }
}
