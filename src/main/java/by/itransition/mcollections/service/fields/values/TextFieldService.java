package by.itransition.mcollections.service.fields.values;

import by.itransition.mcollections.entity.ucollection.values.BoolField;
import by.itransition.mcollections.entity.ucollection.values.TextField;
import by.itransition.mcollections.repos.fields.values.DateFieldRepo;
import by.itransition.mcollections.repos.fields.values.TextFieldRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TextFieldService {

    private final TextFieldRepo repo;

    public TextField save(TextField b) {
        return repo.save(b);
    }
}
