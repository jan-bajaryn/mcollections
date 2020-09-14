package by.itransition.mcollections.mapper;

import by.itransition.mcollections.dto.ThemeDto;
import by.itransition.mcollections.entity.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeMapper {
    ThemeMapper INSTANCE = Mappers.getMapper(ThemeMapper.class);

    List<ThemeDto> toThemeDto(List<Theme> all);
}
