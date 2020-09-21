package by.itransition.mcollections.service.fields.values;

import by.itransition.mcollections.entity.ucollection.values.BoolField;
import by.itransition.mcollections.entity.ucollection.values.DateField;
import by.itransition.mcollections.repos.fields.values.DateFieldRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateFieldService {

    private final DateFieldRepo repo;

    public DateField save(DateField b) {
        return repo.save(b);
    }
}
