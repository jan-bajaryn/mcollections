package by.itransition.mcollections.controller;

import by.itransition.mcollections.dto.ThemeDto;
import by.itransition.mcollections.dto.UcollectionDto;
import by.itransition.mcollections.service.ThemeService;
import by.itransition.mcollections.service.UcollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {

    private final UcollectionService ucollectionService;
    private final ThemeService themeService;

    @GetMapping("/all-collections")
    @PreAuthorize(value = "hasAuthority('CLIENT')")
    public List<UcollectionDto> allCollections() {
        List<UcollectionDto> all = ucollectionService.findAll();
        System.out.println("all = " + all);
        return all;
    }

    @GetMapping("/all-themes")
    public List<ThemeDto> allThemes() {
        return themeService.findAll();
    }

}
