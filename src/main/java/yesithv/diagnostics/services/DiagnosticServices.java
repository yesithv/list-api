package yesithv.diagnostics.services;

import yesithv.diagnostics.model.DiagnosticCollection;
import yesithv.diagnostics.model.DiagnosticType;

import java.util.List;
import java.util.UUID;

public interface DiagnosticServices {

    DiagnosticCollection getDiagnosticById(UUID idDiagnostic);

    List<DiagnosticCollection> getAllDiagnosticsByType(DiagnosticType diagnosticType);

    DiagnosticCollection saveDiagnostic(DiagnosticCollection diagnosticCollection);

    DiagnosticCollection updateDiagnostic(UUID idDiagnostic, DiagnosticCollection diagnosticCollection);

    void deleteDiagnostic(UUID idDiagnostic);

}
