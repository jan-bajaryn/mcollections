package by.itransition.mcollections.controller;

import by.itransition.mcollections.dto.reqbody.ItemCreate;
import by.itransition.mcollections.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/create")
    public boolean itemCreate(@RequestBody ItemCreate itemCreate) {
        return itemService.create(itemCreate);
    }
}
