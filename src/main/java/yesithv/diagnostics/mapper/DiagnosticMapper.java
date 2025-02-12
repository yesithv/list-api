package yesithv.diagnostics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import yesithv.diagnostics.model.DiagnosticEntity;

@Mapper
public interface DiagnosticMapper {
    DiagnosticMapper DIAGNOSTIC_MAPPER = Mappers.getMapper(DiagnosticMapper.class);

    @Mapping(target = "idDiagnostic", source = "oldDiagnostic.idDiagnostic")
    @Mapping(target = "diagnosticType", source = "newDiagnostic.diagnosticType")
    @Mapping(target = "enable", source = "newDiagnostic.enable")
    @Mapping(target = "code", source = "newDiagnostic.code")
    @Mapping(target = "Description", source = "newDiagnostic.Description")
    @Mapping(target = "gender", source = "newDiagnostic.gender")
    DiagnosticEntity updateDiagnostic(DiagnosticEntity oldDiagnostic, DiagnosticEntity newDiagnostic);
}
