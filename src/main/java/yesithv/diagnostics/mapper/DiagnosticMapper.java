package yesithv.diagnostics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import yesithv.diagnostics.model.DiagnosticCollection;

import java.time.LocalDateTime;

@Mapper
public interface DiagnosticMapper {
    DiagnosticMapper DIAGNOSTIC_MAPPER = Mappers.getMapper(DiagnosticMapper.class);

    @Mapping(target = "idDiagnostic", source = "oldDiagnostic.idDiagnostic")
    @Mapping(target = "diagnosticType", source = "newDiagnostic.diagnosticType")
    @Mapping(target = "enable", source = "newDiagnostic.enable")
    @Mapping(target = "code", source = "newDiagnostic.code")
    @Mapping(target = "description", source = "newDiagnostic.description")
    @Mapping(target = "gender", source = "newDiagnostic.gender")
    @Mapping(target = "lastModified", expression = "java(getCurrentDateTime())")
    DiagnosticCollection updateDiagnostic(DiagnosticCollection oldDiagnostic, DiagnosticCollection newDiagnostic);

    default LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}
