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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yesithv.diagnostics.model.DiagnosticCollection;
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

    @GetMapping("/{idDiagnostic}")
    public DiagnosticCollection showById(@PathVariable UUID idDiagnostic) {
        return diagnosticServices.getDiagnosticById(idDiagnostic);
    }

    @GetMapping()
    public List<DiagnosticCollection> showDiagnosticsByType(@RequestParam DiagnosticType diagnosticType) {
        return diagnosticServices.getAllDiagnosticsByType(diagnosticType);
    }

    @PostMapping
    public DiagnosticCollection create(@RequestBody DiagnosticCollection diagnostic) {
        return diagnosticServices.saveDiagnostic(diagnostic);
    }

    @PutMapping("/{idDiagnostic}")
    public DiagnosticCollection update(@PathVariable UUID idDiagnostic, @RequestBody DiagnosticCollection diagnostic) {
        return diagnosticServices.updateDiagnostic(idDiagnostic, diagnostic);
    }

    @DeleteMapping("/{idDiagnostic}")
    public void delete(@PathVariable UUID idDiagnostic) {
        diagnosticServices.deleteDiagnostic(idDiagnostic);
    }
}
