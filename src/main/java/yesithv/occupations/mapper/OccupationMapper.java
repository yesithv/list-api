package yesithv.occupations.mapper;

import yesithv.occupations.model.OccupationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OccupationMapper {

    OccupationMapper OCCUPATION_MAPPER = Mappers.getMapper(OccupationMapper.class);

    @Mapping(target = "idOccupation", source = "oldOccupation.idOccupation")
    @Mapping(target = "enable", source = "newOccupation.enable")
    @Mapping(target = "name", source = "newOccupation.name")
    OccupationEntity updateOccupation(OccupationEntity oldOccupation, OccupationEntity newOccupation);

}
