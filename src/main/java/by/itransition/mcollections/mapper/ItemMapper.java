package by.itransition.mcollections.mapper;

import by.itransition.mcollections.dto.CollectionItem;
import by.itransition.mcollections.dto.ShowFieldDto;
import by.itransition.mcollections.dto.reqbody.fields.FieldDto;
import by.itransition.mcollections.entity.Tag;
import by.itransition.mcollections.entity.ucollection.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    default List<CollectionItem> toCollectionItems(List<Item> items) {
        return items.stream()
                .map(this::toUcollectionItem)
                .collect(Collectors.toList());
    }

    default CollectionItem toUcollectionItem(Item item) {
        return CollectionItem.builder()
                .id(item.getId())
                .tags(tags(item.getTags()))
                .name(item.getName())
                .boolFields(boolFields(item))
                .dateFields(dateFields(item))
                .stringFields(stringFields(item))
                .textFields(textFields(item))
                .intFields(intFields(item))
                .build();
    }

    default List<String> tags(List<Tag> tags) {
        if (tags != null) {
            return tags.stream()
                    .map(Tag::getName)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    default List<ShowFieldDto<Boolean>> boolFields(Item item) {
        if (item != null) {
            return item.getBoolFields().stream()
                    .map(b -> new ShowFieldDto<>(b.getBoolFieldName().getName(), b.isValue()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    default List<ShowFieldDto<String>> textFields(Item item) {
        if (item != null) {
            return item.getTextFields().stream()
                    .map(b -> new ShowFieldDto<>(b.getTextFieldName().getName(), b.getValue()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    default List<ShowFieldDto<String>> stringFields(Item item) {
        if (item != null) {
            return item.getStringFields().stream()
                    .map(b -> new ShowFieldDto<>(b.getStringFieldName().getName(), b.getValue()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    default List<ShowFieldDto<Integer>> intFields(Item item) {
        if (item != null) {
            return item.getIntFields().stream()
                    .map(b -> new ShowFieldDto<>(b.getIntFieldName().getName(), b.getValue()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    default List<ShowFieldDto<LocalDateTime>> dateFields(Item item) {
        if (item != null) {
            return item.getDateFields().stream()
                    .map(b -> new ShowFieldDto<>(b.getDateFieldName().getName(), b.getValue()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

}
