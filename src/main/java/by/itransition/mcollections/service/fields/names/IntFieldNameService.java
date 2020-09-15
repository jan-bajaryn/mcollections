package by.itransition.mcollections.service.fields.names;

import by.itransition.mcollections.entity.ucollection.names.IntFieldName;
import by.itransition.mcollections.entity.ucollection.names.IntFieldName;
import by.itransition.mcollections.repos.fields.names.IntFieldNameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IntFieldNameService {

    private final IntFieldNameRepo repo;

    public boolean saveAll(List<IntFieldName> fieldNames) {
        return repo.saveAll(fieldNames).stream()
                .map(e -> e.getId() != null)
                .reduce(true, (f, s) -> f && s);
    }
}
