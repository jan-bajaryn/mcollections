package by.itransition.mcollections.controller;

import by.itransition.mcollections.dto.ShowSingleItemDto;
import by.itransition.mcollections.dto.reqbody.ItemCreate;
import by.itransition.mcollections.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@PreAuthorize(value = "hasAuthority('CLIENT')")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/create")
    public boolean itemCreate(@RequestBody ItemCreate itemCreate) {
        return itemService.create(itemCreate);
    }

    @GetMapping("/item/{id}")
    public ShowSingleItemDto item(@PathVariable(name = "id") Integer id) {
        return itemService.showSingleById(id);
    }

}
