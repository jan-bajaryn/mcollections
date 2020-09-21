package by.itransition.mcollections.service.fields.values;

import by.itransition.mcollections.entity.ucollection.values.BoolField;
import by.itransition.mcollections.entity.ucollection.values.StringField;
import by.itransition.mcollections.repos.fields.values.DateFieldRepo;
import by.itransition.mcollections.repos.fields.values.StringFieldRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StringFieldService {

    private final StringFieldRepo repo;

    public StringField save(StringField b) {
        return repo.save(b);
    }
}
