package by.itransition.mcollections.service.fields;

import by.itransition.mcollections.repos.fields.values.BoolFieldRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoolFieldService {

    private final BoolFieldRepo boolFieldRepo;

}
