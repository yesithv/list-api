package yesithv.diagnostics.services;

import yesithv.diagnostics.model.DiagnosticEntity;
import yesithv.diagnostics.model.DiagnosticType;

import java.util.List;
import java.util.UUID;

public interface DiagnosticServices {

    DiagnosticEntity getDiagnosticById(UUID idDiagnostic);

    List<DiagnosticEntity> getAllDiagnosticsByType(DiagnosticType diagnosticType);

    DiagnosticEntity saveDiagnostic(DiagnosticEntity diagnosticEntity);

    DiagnosticEntity updateDiagnostic(UUID idDiagnostic, DiagnosticEntity diagnosticEntity);

    void deleteDiagnostic(UUID idDiagnostic);

}
