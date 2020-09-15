package by.itransition.mcollections.service.fields.names;

import by.itransition.mcollections.entity.ucollection.names.TextFieldName;
import by.itransition.mcollections.entity.ucollection.names.TextFieldName;
import by.itransition.mcollections.repos.fields.names.TextFieldNameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextFieldNameService {

    private final TextFieldNameRepo repo;

    public boolean saveAll(List<TextFieldName> fieldNames) {
        return repo.saveAll(fieldNames).stream()
                .map(e -> e.getId() != null)
                .reduce(true, (f, s) -> f && s);
    }
}
