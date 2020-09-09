package by.itransition.mcollections.controller;

import by.itransition.mcollections.dto.UcollectionDto;
import by.itransition.mcollections.entity.UCollection;
import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.mapper.UserMapper;
import by.itransition.mcollections.service.UcollectionService;
import by.itransition.mcollections.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {

    private final UcollectionService ucollectionService;

    @GetMapping("/all-collections")
    public List<UcollectionDto> allCollections() {
        return ucollectionService.findAll();
    }

    @PostMapping("/create-collection")
    public Response createCollection(@RequestParam(name = "name") String name,
                                     @RequestParam(name = "description") String description
//            ,
//                                   @RequestParam(name = "")
    ) {
        return Response.builder().error(false).build();
    }

}
