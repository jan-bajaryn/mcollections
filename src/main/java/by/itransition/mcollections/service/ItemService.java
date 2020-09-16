package by.itransition.mcollections.service;

import by.itransition.mcollections.dto.reqbody.ItemCreate;
import by.itransition.mcollections.entity.Tag;
import by.itransition.mcollections.entity.ucollection.Item;
import by.itransition.mcollections.entity.ucollection.values.BoolField;
import by.itransition.mcollections.repos.ItemRepo;
import by.itransition.mcollections.service.fields.BoolFieldService;
import by.itransition.mcollections.service.fields.names.BoolFieldNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;

    private final TagService tagService;

    private final BoolFieldService boolFieldService;
    private final BoolFieldNameService boolFieldNameService;


    public boolean create(ItemCreate itemCreate) {
        Item item = new Item();
        item.setName(itemCreate.getName());
        item.setTags(makeTags(itemCreate));
//        item.setBoolFields(makeBoolFields(itemCreate.getBoolFields()));
        Item save = itemRepo.save(item);
        return save.getId() != null &&
                saveRelations(save, itemCreate);
    }

    // TODO end that
    private boolean saveRelations(Item save, ItemCreate itemCreate) {
        return true;
    }

    private List<Tag> makeTags(ItemCreate itemCreate) {
        return itemCreate.getTags().stream()
                .map(tagService::findByNameOrCreate)
                .collect(Collectors.toList());
    }
}
