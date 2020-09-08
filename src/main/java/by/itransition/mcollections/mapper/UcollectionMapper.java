package by.itransition.mcollections.mapper;

import by.itransition.mcollections.dto.UcollectionDto;
import by.itransition.mcollections.entity.UCollection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UcollectionMapper {

    UcollectionMapper INSTANCE = Mappers.getMapper(UcollectionMapper.class);

    List<UcollectionDto> toUcollectionDtoList(List<UCollection> uCollections);
}
