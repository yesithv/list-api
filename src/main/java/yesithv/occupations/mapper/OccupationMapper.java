package yesithv.occupations.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import yesithv.occupations.model.OccupationCollection;

import java.time.LocalDateTime;

@Mapper
public interface OccupationMapper {

    OccupationMapper OCCUPATION_MAPPER = Mappers.getMapper(OccupationMapper.class);

    @Mapping(target = "idOccupation", source = "oldOccupation.idOccupation")
    @Mapping(target = "enable", source = "newOccupation.enable")
    @Mapping(target = "name", source = "newOccupation.name")
    @Mapping(target = "anniversary", source = "newOccupation.anniversary")
    @Mapping(target = "lastModified", expression = "java(getCurrentDateTime())")
    OccupationCollection updateOccupation(OccupationCollection oldOccupation, OccupationCollection newOccupation);

    default LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}
