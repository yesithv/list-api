package yesithv.diagnostics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import yesithv.diagnostics.model.DiagnosticEntity;
import yesithv.diagnostics.model.DiagnosticType;

import java.util.List;
import java.util.UUID;

public interface DiagnosticRepository extends MongoRepository<DiagnosticEntity, UUID> {

    @Query("{ 'enable': true, 'diagnosticType': ?0 }")
    List<DiagnosticEntity> findAllEnabledByDiagnosticType(DiagnosticType diagnosticType);
}
