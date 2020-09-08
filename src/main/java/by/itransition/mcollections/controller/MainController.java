package by.itransition.mcollections.controller;

import by.itransition.mcollections.dto.UcollectionDto;
import by.itransition.mcollections.entity.UCollection;
import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.mapper.UserMapper;
import by.itransition.mcollections.service.UcollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final UcollectionService ucollectionService;

    @GetMapping("/all-collections")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<UcollectionDto> allCollections() {
        return ucollectionService.findAll();
    }


}
