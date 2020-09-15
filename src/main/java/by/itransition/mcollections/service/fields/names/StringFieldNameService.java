package by.itransition.mcollections.service.fields.names;

import by.itransition.mcollections.entity.ucollection.names.StringFieldName;
import by.itransition.mcollections.entity.ucollection.names.StringFieldName;
import by.itransition.mcollections.repos.fields.names.StringFieldNameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StringFieldNameService {

    private final StringFieldNameRepo repo;

    public boolean saveAll(List<StringFieldName> fieldNames) {
        return repo.saveAll(fieldNames).stream()
                .map(e -> e.getId() != null)
                .reduce(true, (f, s) -> f && s);
    }
}
