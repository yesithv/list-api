package ironcoding.listapi.diagnostics.services;

import ironcoding.listapi.diagnostics.model.DiagnosticEntity;
import ironcoding.listapi.diagnostics.model.DiagnosticType;
import ironcoding.listapi.diagnostics.repository.DiagnosticRepository;
import ironcoding.listapi.exceptions.ListNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static ironcoding.listapi.exceptions.ErrorCatalog.DONT_FIND_DIAGNOSTIC;
import static ironcoding.listapi.utils.ListType.DIAGNOSTICS;

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
        log.info("Enter to updateDiagnostic(). IdDiagnostic: [{}]. New diagnostic: [{}]", idDiagnostic, diagnosticEntity);
        var oldDiagnostic = diagnosticRepository.findById(idDiagnostic).orElseThrow(() -> new ListNotFoundException(String.format(DONT_FIND_DIAGNOSTIC.getDescription(), idDiagnostic), DONT_FIND_DIAGNOSTIC.getCode(), DIAGNOSTICS));
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
