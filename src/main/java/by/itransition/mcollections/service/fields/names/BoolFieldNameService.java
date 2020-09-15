package by.itransition.mcollections.service.fields.names;

import by.itransition.mcollections.entity.ucollection.names.BoolFieldName;
import by.itransition.mcollections.repos.fields.names.BoolFieldNameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoolFieldNameService {

    private final BoolFieldNameRepo repo;

    public boolean saveAll(List<BoolFieldName> boolFieldNames) {
        return repo.saveAll(boolFieldNames).stream()
                .map(e -> e.getId() != null)
                .reduce(true, (f, s) -> f && s);
    }
}
