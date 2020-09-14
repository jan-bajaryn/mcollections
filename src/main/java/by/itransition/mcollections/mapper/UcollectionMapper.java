package by.itransition.mcollections.mapper;

import by.itransition.mcollections.dto.ShowCollectionDto;
import by.itransition.mcollections.dto.UcollectionDto;
import by.itransition.mcollections.dto.reqbody.UcollectionForCreate;
import by.itransition.mcollections.entity.UCollection;
import by.itransition.mcollections.repos.ThemeRepo;
import by.itransition.mcollections.repos.UCollectionRepo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ThemeRepo.class, UserMapper.class})
public abstract class UcollectionMapper {

    private static final UcollectionMapper INSTANCE = Mappers.getMapper(UcollectionMapper.class);

    public abstract List<UcollectionDto> toUcollectionDtoList(List<UCollection> uCollections);

    @Mapping(target = "theme", source = "themeId")
    public abstract UCollection toUcollection(UcollectionForCreate ucollection);


    @Mapping(target = "rowNames", ignore = true)
    public abstract ShowCollectionDto toShowCollection(UCollection uCollection);

    @AfterMapping
    protected void setPhones(UCollection from, @MappingTarget ShowCollectionDto.ShowCollectionDtoBuilder to) {
        ArrayList<String> rowNames = new ArrayList<>();
        to.rowNames(rowNames);

        System.out.println("from = " + from);
        System.out.println("to = " + to);

        addValueIfNotEmpty(from.getBool1Name(), rowNames);
        addValueIfNotEmpty(from.getBool2Name(), rowNames);
        addValueIfNotEmpty(from.getBool3Name(), rowNames);
        addValueIfNotEmpty(from.getInt1Name(), rowNames);
        addValueIfNotEmpty(from.getInt2Name(), rowNames);
        addValueIfNotEmpty(from.getInt3Name(), rowNames);
        addValueIfNotEmpty(from.getString1Name(), rowNames);
        addValueIfNotEmpty(from.getString2Name(), rowNames);
        addValueIfNotEmpty(from.getString3Name(), rowNames);
        addValueIfNotEmpty(from.getText1Name(), rowNames);
        addValueIfNotEmpty(from.getText2Name(), rowNames);
        addValueIfNotEmpty(from.getText3Name(), rowNames);
        addValueIfNotEmpty(from.getDate1Name(), rowNames);
        addValueIfNotEmpty(from.getDate2Name(), rowNames);
        addValueIfNotEmpty(from.getDate3Name(), rowNames);

    }

    protected void addValueIfNotEmpty(String value, List<String> list) {
        if (value != null && !value.isEmpty()) {
            list.add(value);
        }
    }
}
