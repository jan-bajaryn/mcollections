package by.itransition.mcollections.service.fields.values;

import by.itransition.mcollections.entity.ucollection.values.BoolField;
import by.itransition.mcollections.entity.ucollection.values.IntField;
import by.itransition.mcollections.repos.fields.values.DateFieldRepo;
import by.itransition.mcollections.repos.fields.values.IntFieldRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntFieldService {

    private final IntFieldRepo repo;

    public IntField save(IntField b) {
        return repo.save(b);
    }
}
