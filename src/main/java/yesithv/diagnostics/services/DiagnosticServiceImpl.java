package yesithv.diagnostics.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import yesithv.diagnostics.model.DiagnosticCollection;
import yesithv.diagnostics.model.DiagnosticType;
import yesithv.diagnostics.repository.DiagnosticRepository;
import yesithv.exceptions.ListNotFoundException;

import java.util.List;
import java.util.UUID;

import static yesithv.diagnostics.mapper.DiagnosticMapper.DIAGNOSTIC_MAPPER;
import static yesithv.exceptions.ErrorCatalog.DONT_FIND_DIAGNOSTIC;
import static yesithv.utils.ListType.DIAGNOSTICS;

@Slf4j
@Service
@AllArgsConstructor
public class DiagnosticServiceImpl implements DiagnosticServices {

    private final DiagnosticRepository diagnosticRepository;

    @Override
    public DiagnosticCollection getDiagnosticById(UUID idDiagnostic) {
        log.info("Enter to getDiagnosticById.  idDiagnostic {}", idDiagnostic);
        var diagnostic = diagnosticRepository.findById(idDiagnostic);
        log.info("Diagnostic found ? {}", diagnostic.isPresent());
        return diagnostic.orElse(null);
    }

    @Override
    public List<DiagnosticCollection> getAllDiagnosticsByType(DiagnosticType diagnosticType) {
        log.info("Enter to getAllDiagnosticsByType. diagnosticType: {}", diagnosticType);
        var diagnosticList = diagnosticRepository.findAllEnabledByDiagnosticType(diagnosticType);
        log.info("Diagnostics found: {}", diagnosticList.size());
        return diagnosticList;
    }

    @Override
    public DiagnosticCollection saveDiagnostic(DiagnosticCollection diagnosticCollection) {
        log.info("Enter to saveDiagnostic. New diagnostic: {} ", diagnosticCollection);
        var diagnostic = diagnosticRepository.save(diagnosticCollection);
        log.info("Diagnostic saved ? {}", diagnostic != null);
        return diagnostic;
    }

    @Override
    public DiagnosticCollection updateDiagnostic(UUID idDiagnostic, DiagnosticCollection newDiagnostic) {
        log.info("Enter to updateDiagnostic. IdDiagnostic: {}. New diagnostic: {}", idDiagnostic, newDiagnostic);
        var oldDiagnostic = diagnosticRepository.findById(idDiagnostic).orElseThrow(() -> new ListNotFoundException(String.format(DONT_FIND_DIAGNOSTIC.getDescription(), idDiagnostic), DONT_FIND_DIAGNOSTIC.getCode(), DIAGNOSTICS));
        log.info("Old diagnostic found ? {}", oldDiagnostic != null);
        var updateDiagnostic = diagnosticRepository.save(DIAGNOSTIC_MAPPER.updateDiagnostic(oldDiagnostic, newDiagnostic));
        log.info("Diagnostic updated ? {}", updateDiagnostic != null);
        return updateDiagnostic;
    }

    @Override
    public void deleteDiagnostic(UUID idDiagnostic) {
        log.info("Enter to delete diagnostic. idDiagnostic: {}", idDiagnostic);
        if (!diagnosticRepository.existsById(idDiagnostic)) {
            log.error("Diagnostic with id: {} doesn't exist, so It can't be deleted", idDiagnostic);
            return;
        }
        diagnosticRepository.deleteById(idDiagnostic);
        log.info("Diagnostic deleted");
    }


}
