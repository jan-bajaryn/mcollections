package by.itransition.mcollections.mapper;

import by.itransition.mcollections.dto.ShowCollectionDto;
import by.itransition.mcollections.dto.UcollectionDto;
import by.itransition.mcollections.dto.reqbody.UcollectionForCreate;
import by.itransition.mcollections.entity.ucollection.UCollection;
import by.itransition.mcollections.entity.ucollection.names.*;
import by.itransition.mcollections.repos.ThemeRepo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {ThemeRepo.class, UserMapper.class})
public abstract class UcollectionMapper {

    private static final UcollectionMapper INSTANCE = Mappers.getMapper(UcollectionMapper.class);

    public abstract List<UcollectionDto> toUcollectionDtoList(List<UCollection> uCollections);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "boolFieldNames", ignore = true)
    @Mapping(target = "stringFieldNames", ignore = true)
    @Mapping(target = "dateFieldNames", ignore = true)
    @Mapping(target = "textFieldNames", ignore = true)
    @Mapping(target = "intFieldNames", ignore = true)
    @Mapping(target = "theme", source = "themeId")
    public abstract UCollection toUcollection(UcollectionForCreate ucollection);

    @AfterMapping
    protected void afterToUcollection(UcollectionForCreate from, @MappingTarget UCollection.UCollectionBuilder to) {
        to.boolFieldNames(from.getBoolFieldNames().stream().map(p -> BoolFieldName.builder().name(p).build()).collect(Collectors.toList()));
        to.dateFieldNames(from.getDateFieldNames().stream().map(p -> DateFieldName.builder().name(p).build()).collect(Collectors.toList()));
        to.textFieldNames(from.getTextFieldNames().stream().map(p -> TextFieldName.builder().name(p).build()).collect(Collectors.toList()));
        to.intFieldNames(from.getIntFieldNames().stream().map(p -> IntFieldName.builder().name(p).build()).collect(Collectors.toList()));
        to.stringFieldNames(from.getStringFieldNames().stream().map(p -> StringFieldName.builder().name(p).build()).collect(Collectors.toList()));
    }

    @Mapping(target = "rowNames", ignore = true)
    public abstract ShowCollectionDto toShowCollection(UCollection uCollection);

    @AfterMapping
    protected void setPhones(UCollection from, @MappingTarget ShowCollectionDto.ShowCollectionDtoBuilder to) {
        ArrayList<String> rowNames = new ArrayList<>();
        to.rowNames(rowNames);
        boolAndInt(from, rowNames);
        dateAndString(from, rowNames);
        text(from, rowNames);
    }

    private void text(UCollection from, ArrayList<String> rowNames) {
        for (TextFieldName textFieldName : from.getTextFieldNames()) {
            rowNames.add(textFieldName.getName());
        }
    }

    private void dateAndString(UCollection from, ArrayList<String> rowNames) {
        for (DateFieldName dateFieldName : from.getDateFieldNames()) {
            rowNames.add(dateFieldName.getName());
        }

        for (StringFieldName stringFieldName : from.getStringFieldNames()) {
            rowNames.add(stringFieldName.getName());
        }
    }

    private void boolAndInt(UCollection from, ArrayList<String> rowNames) {
        for (BoolFieldName boolFieldName : from.getBoolFieldNames()) {
            rowNames.add(boolFieldName.getName());
        }
        for (IntFieldName intFieldName : from.getIntFieldNames()) {
            rowNames.add(intFieldName.getName());
        }
    }

}
