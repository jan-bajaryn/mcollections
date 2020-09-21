package by.itransition.mcollections.service.fields.values;

import by.itransition.mcollections.entity.ucollection.values.BoolField;
import by.itransition.mcollections.entity.ucollection.values.DateField;
import by.itransition.mcollections.repos.fields.values.BoolFieldRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoolFieldService {

    private final BoolFieldRepo boolFieldRepo;

    public BoolField save(BoolField b) {
        return boolFieldRepo.save(b);
    }

}
