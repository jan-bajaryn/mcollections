package by.itransition.mcollections.service;

import by.itransition.mcollections.entity.Tag;
import by.itransition.mcollections.repos.TagRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepo tagRepo;

    public Tag findByNameOrCreate(String name) {
        Tag byName = tagRepo.findByName(name);
        if (byName == null) {
            byName = tagRepo.save(Tag.builder().name(name).build());
        }
        return byName;
    }
}
