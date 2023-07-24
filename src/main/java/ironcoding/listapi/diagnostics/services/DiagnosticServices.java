package ironcoding.listapi.diagnostics.services;

import ironcoding.listapi.diagnostics.model.DiagnosticEntity;
import ironcoding.listapi.diagnostics.model.DiagnosticType;

import java.util.List;
import java.util.UUID;

public interface DiagnosticServices {

    DiagnosticEntity saveDiagnostic(DiagnosticEntity diagnosticEntity);

    DiagnosticEntity updateDiagnostic(UUID idDiagnostic, DiagnosticEntity diagnosticEntity);

    void deleteDiagnostic(UUID idDiagnostic);

    DiagnosticEntity findDiagnosticById(UUID idDiagnostic);

    List<DiagnosticEntity> findAllDiagnosticsByType(DiagnosticType diagnosticType);

}
