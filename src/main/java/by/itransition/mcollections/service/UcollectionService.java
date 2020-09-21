package by.itransition.mcollections.service;

import by.itransition.mcollections.dto.CollectionItem;
import by.itransition.mcollections.dto.ShowCollectionDto;
import by.itransition.mcollections.dto.UcollectionDto;
import by.itransition.mcollections.dto.columninfo.ColumnInfo;
import by.itransition.mcollections.dto.columninfo.UcollColumnInfo;
import by.itransition.mcollections.dto.reqbody.UcollectionForCreate;
import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.entity.ucollection.Item;
import by.itransition.mcollections.entity.ucollection.UCollection;
import by.itransition.mcollections.entity.ucollection.names.*;
import by.itransition.mcollections.mapper.ItemMapper;
import by.itransition.mcollections.mapper.UcollectionMapper;
import by.itransition.mcollections.repos.UCollectionRepo;
import by.itransition.mcollections.service.fields.names.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UcollectionService {

    private final UCollectionRepo uCollectionRepo;
    private final UcollectionMapper ucollectionMapper;
    private final ItemMapper itemMapper;

    private final BoolFieldNameService boolFieldNameService;
    private final IntFieldNameService intFieldNameService;
    private final DateFieldNameService dateFieldNameService;
    private final StringFieldNameService stringFieldNameService;
    private final TextFieldNameService textFieldNameService;

    public List<UcollectionDto> findAll() {
        return ucollectionMapper.toUcollectionDtoList(uCollectionRepo.findAll());
    }

    public boolean save(UcollectionForCreate ucollection, User user) {
        UCollection uCollection = ucollectionMapper.toUcollection(ucollection);
        uCollection.setAuthor(user);
        UCollection save = uCollectionRepo.save(uCollection);
        return saveRelations(save) && save.getId() != null;
    }

    private boolean saveRelations(UCollection save) {
        makeRelationEntity(save);
        return boolFieldNameService.saveAll(save.getBoolFieldNames()) &&
                intFieldNameService.saveAll(save.getIntFieldNames()) &&
                dateFieldNameService.saveAll(save.getDateFieldNames()) &&
                textFieldNameService.saveAll(save.getTextFieldNames()) &&
                stringFieldNameService.saveAll(save.getStringFieldNames());
    }

    private void makeRelationEntity(UCollection save) {
        makeRelationEntityText(save);
        makeRelationEntityInt(save);
        makeRelationEntityString(save);
        makeRelationEntityDate(save);
        makeRelationEntityBool(save);

    }

    private void makeRelationEntityBool(UCollection save) {
        for (BoolFieldName boolFieldName : save.getBoolFieldNames()) {
            boolFieldName.setUCollection(save);
        }
    }

    private void makeRelationEntityDate(UCollection save) {
        for (DateFieldName dateFieldName : save.getDateFieldNames()) {
            dateFieldName.setUCollection(save);
        }
    }

    private void makeRelationEntityString(UCollection save) {
        for (StringFieldName stringFieldName : save.getStringFieldNames()) {
            stringFieldName.setUCollection(save);
        }
    }

    private void makeRelationEntityInt(UCollection save) {
        for (IntFieldName intFieldName : save.getIntFieldNames()) {
            intFieldName.setUCollection(save);
        }
    }

    private void makeRelationEntityText(UCollection save) {
        for (TextFieldName textFieldName : save.getTextFieldNames()) {
            textFieldName.setUCollection(save);
        }
    }

    public ShowCollectionDto showCollectionById(Integer id) {
        Optional<UCollection> byId = uCollectionRepo.findById(id);
        return byId.map(ucollectionMapper::toShowCollection).orElse(null);
    }

    public UcollColumnInfo columnInfoById(Integer id) {
        Optional<UCollection> byId = uCollectionRepo.findById(id);
        return byId.map(this::transferColumns).orElse(null);
    }

    private UcollColumnInfo transferColumns(UCollection uCollection) {
        UcollColumnInfo info = new UcollColumnInfo();
        makeTransfer(uCollection, info);
        return info;
    }

    private void makeTransfer(UCollection uCollection, UcollColumnInfo info) {
        transferTextColumn(uCollection, info);
        transferStringColumn(uCollection, info);
        transferDateColumn(uCollection, info);
        transferIntColumn(uCollection, info);
        transferBoolColumn(uCollection, info);
    }

    private void transferBoolColumn(UCollection uCollection, UcollColumnInfo info) {
        info.setBoolFieldNames(
                uCollection.getBoolFieldNames().stream()
                        .map(k -> ColumnInfo.builder().id(k.getId()).name(k.getName()).build())
                        .collect(Collectors.toList())
        );
    }

    private void transferIntColumn(UCollection uCollection, UcollColumnInfo info) {
        info.setIntFieldNames(
                uCollection.getIntFieldNames().stream()
                        .map(k -> ColumnInfo.builder().id(k.getId()).name(k.getName()).build())
                        .collect(Collectors.toList())
        );
    }

    private void transferDateColumn(UCollection uCollection, UcollColumnInfo info) {
        info.setDateFieldNames(
                uCollection.getDateFieldNames().stream()
                        .map(k -> ColumnInfo.builder().id(k.getId()).name(k.getName()).build())
                        .collect(Collectors.toList())
        );
    }

    private void transferStringColumn(UCollection uCollection, UcollColumnInfo info) {
        info.setStringFieldNames(
                uCollection.getStringFieldNames().stream()
                        .map(k -> ColumnInfo.builder().id(k.getId()).name(k.getName()).build())
                        .collect(Collectors.toList())
        );
    }

    private void transferTextColumn(UCollection uCollection, UcollColumnInfo info) {
        info.setTextFieldNames(
                uCollection.getTextFieldNames().stream()
                        .map(k -> ColumnInfo.builder().id(k.getId()).name(k.getName()).build())
                        .collect(Collectors.toList())
        );
    }

    public List<CollectionItem> showItemsById(Integer id) {
        Optional<UCollection> byId = uCollectionRepo.findById(id);
        if(byId.isPresent()) {
            UCollection uCollection = byId.get();
            List<Item> items = uCollection.getItems();
            return itemMapper.toCollectionItems(items);
        }
        return new ArrayList<>();
    }
}
