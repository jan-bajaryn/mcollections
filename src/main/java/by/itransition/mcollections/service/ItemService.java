package by.itransition.mcollections.service;

import by.itransition.mcollections.dto.reqbody.ItemCreate;
import by.itransition.mcollections.dto.reqbody.fields.FieldDto;
import by.itransition.mcollections.entity.Tag;
import by.itransition.mcollections.entity.ucollection.Item;
import by.itransition.mcollections.entity.ucollection.UCollection;
import by.itransition.mcollections.entity.ucollection.names.*;
import by.itransition.mcollections.entity.ucollection.values.*;
import by.itransition.mcollections.repos.ItemRepo;
import by.itransition.mcollections.service.fields.names.*;
import by.itransition.mcollections.service.fields.values.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;

    private final TagService tagService;

    private final BoolFieldService boolFieldService;
    private final BoolFieldNameService boolFieldNameService;

    private final TextFieldService textFieldService;
    private final TextFieldNameService textFieldNameService;
    private final StringFieldService stringFieldService;
    private final StringFieldNameService stringFieldNameService;
    private final DateFieldService dateFieldService;
    private final DateFieldNameService dateFieldNameService;
    private final IntFieldService intFieldService;
    private final IntFieldNameService intFieldNameService;


    public boolean create(ItemCreate itemCreate) {
        Item item = new Item();
        item.setUCollection(UCollection.builder().id(itemCreate.getCollectionId()).build());
        item.setName(itemCreate.getName());
        item.setTags(makeTags(itemCreate));
        Item save = itemRepo.save(item);
        saveRelations(save, itemCreate);
        return save.getId() != null;
    }


    private List<Tag> makeTags(ItemCreate itemCreate) {
        return itemCreate.getTags().stream()
                .map(tagService::findByNameOrCreate)
                .collect(Collectors.toList());
    }

    private void saveRelations(Item save, ItemCreate itemCreate) {
        makeBoolFields(save, itemCreate);
        makeTextFields(save, itemCreate);
        makeStringFields(save, itemCreate);
        makeDateFields(save, itemCreate);
        makeIntFields(save, itemCreate);
    }


    private void makeDateFields(Item save, ItemCreate itemCreate) {
        save.setDateFields(itemCreate.getDateFields().stream()
                .map(b -> buildDateField(b, save))
                .map(dateFieldService::save)
                .collect(Collectors.toList()));
    }


    private void makeIntFields(final Item save, ItemCreate itemCreate) {
        save.setIntFields(itemCreate.getIntFields().stream()
                .map(b -> buildIntField(b, save))
                .map(intFieldService::save)
                .collect(Collectors.toList()));
    }

    private void makeStringFields(Item save, ItemCreate itemCreate) {
        save.setStringFields(itemCreate.getStringFields().stream()
                .map(b -> buildStringField(b, save))
                .map(stringFieldService::save)
                .collect(Collectors.toList()));
    }

    private void makeTextFields(Item save, ItemCreate itemCreate) {
        save.setTextFields(itemCreate.getTextFields().stream()
                .map(b -> buildTextField(b, save))
                .map(textFieldService::save)
                .collect(Collectors.toList()));
    }


    private void makeBoolFields(Item save, ItemCreate itemCreate) {
        save.setBoolFields(itemCreate.getBoolFields().stream()
                .map(b -> buildBoolField(b, save))
                .map(boolFieldService::save)
                .collect(Collectors.toList()));
    }

    private BoolField buildBoolField(FieldDto<Boolean> b, Item item) {
        return BoolField.builder()
                .boolFieldName(
                        buildBoolFieldWithId(b))
                .value(b.getValue())
                .item(item)
                .build();
    }

    private IntField buildIntField(FieldDto<Integer> b, Item item) {
        return IntField.builder()
                .intFieldName(
                        buildIntFieldWithId(b))
                .value(b.getValue())
                .item(item)
                .build();
    }

    private DateField buildDateField(FieldDto<LocalDateTime> b, Item item) {
        return DateField.builder()
                .dateFieldName(
                        buildDateFieldWithId(b))
                .value(b.getValue())
                .item(item)
                .build();
    }

    private TextField buildTextField(FieldDto<String> b, Item item) {
        return TextField.builder()
                .textFieldName(
                        buildTextFieldWithId(b))
                .value(b.getValue())
                .item(item)
                .build();
    }

    private StringField buildStringField(FieldDto<String> b, Item item) {
        return StringField.builder()
                .stringFieldName(
                        buildStringFieldWithId(b))
                .value(b.getValue())
                .item(item)
                .build();
    }


    private BoolFieldName buildBoolFieldWithId(FieldDto<Boolean> b) {
        return BoolFieldName.builder().
                id(b.getNameId()).build();
    }

    private TextFieldName buildTextFieldWithId(FieldDto<String> b) {
        return TextFieldName.builder().
                id(b.getNameId()).build();
    }

    private StringFieldName buildStringFieldWithId(FieldDto<String> b) {
        return StringFieldName.builder().
                id(b.getNameId()).build();
    }

    private DateFieldName buildDateFieldWithId(FieldDto<LocalDateTime> b) {
        return DateFieldName.builder().
                id(b.getNameId()).build();
    }

    private IntFieldName buildIntFieldWithId(FieldDto<Integer> b) {
        return IntFieldName.builder().
                id(b.getNameId()).build();
    }


}
