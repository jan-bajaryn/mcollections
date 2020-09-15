package by.itransition.mcollections.service.fields.names;

import by.itransition.mcollections.entity.ucollection.names.DateFieldName;
import by.itransition.mcollections.entity.ucollection.names.DateFieldName;
import by.itransition.mcollections.repos.fields.names.DateFieldNameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DateFieldNameService {

    private final DateFieldNameRepo repo;

    public boolean saveAll(List<DateFieldName> fieldNames) {
        return repo.saveAll(fieldNames).stream()
                .map(e -> e.getId() != null)
                .reduce(true, (f, s) -> f && s);
    }
}
