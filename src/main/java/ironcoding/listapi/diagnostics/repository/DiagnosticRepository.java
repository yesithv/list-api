package ironcoding.listapi.diagnostics.repository;

import ironcoding.listapi.diagnostics.model.DiagnosticEntity;
import ironcoding.listapi.diagnostics.model.DiagnosticType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DiagnosticRepository extends JpaRepository<DiagnosticEntity, UUID> {

    List<DiagnosticEntity> findAllByEnableAndAndDiagnosticType(boolean enable, DiagnosticType diagnosticType);
}
