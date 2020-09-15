package by.itransition.mcollections.controller;

import by.itransition.mcollections.dto.ShowCollectionDto;
import by.itransition.mcollections.dto.columninfo.UcollColumnInfo;
import by.itransition.mcollections.dto.reqbody.UcollectionForCreate;
import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.service.UcollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UCollectionsController {

    private final UcollectionService ucollectionService;

    @PostMapping("/collection/create")
    @PreAuthorize(value = "hasAuthority('CLIENT')")
    public boolean create(@RequestBody UcollectionForCreate ucollection,
                          @AuthenticationPrincipal User user) {
        System.out.println("user = " + user.getId());
        return ucollectionService.save(ucollection, user);
    }

    @GetMapping("/collection/{id}")
    public ShowCollectionDto collectionId(@PathVariable(name = "id") Integer id) {
        return ucollectionService.showCollectionById(id);
    }

    @GetMapping("/collection/columns/{id}")
    public UcollColumnInfo collectionColumnsId(@PathVariable(name = "id") Integer id) {
        return ucollectionService.columnInfoById(id);
    }

}
