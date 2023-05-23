package ironcoding.listapi.diagnostics.services;

import ironcoding.listapi.diagnostics.model.DiagnosticEntity;
import ironcoding.listapi.diagnostics.model.DiagnosticType;
import ironcoding.listapi.diagnostics.repository.DiagnosticRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class DiagnosticServiceImpl implements DiagnosticServices {

    private final DiagnosticRepository diagnosticRepository;

    @Override
    public DiagnosticEntity saveDiagnostic(DiagnosticEntity diagnosticEntity) {
        log.info("Enter to saveDiagnostic(). New diagnostic: [{}] ", diagnosticEntity);
        return diagnosticRepository.save(diagnosticEntity);
    }

    @Override
    public DiagnosticEntity updateDiagnostic(UUID idDiagnostic, DiagnosticEntity diagnosticEntity) {
        return null;
    }

    @Override
    public void deleteDiagnostic(UUID idDiagnostic) {

    }

    @Override
    public DiagnosticEntity findDiagnosticById(UUID idDiagnostic) {
        return null;
    }

    @Override
    public List<DiagnosticEntity> findAllDiagnosticsByType(DiagnosticType diagnosticType) {
        return null;
    }
}
