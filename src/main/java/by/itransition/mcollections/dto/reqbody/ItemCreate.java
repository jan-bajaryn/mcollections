package by.itransition.mcollections.dto.reqbody;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class ItemCreate {
    private Integer collectionId;
    private String name;
    private List<String> tags;
    private Map<Integer, Boolean> boolFields;
    private Map<Integer, LocalDateTime> dateFields;
    private Map<Integer, Integer> intFields;
    private Map<Integer, String> stringFields;
    private Map<Integer, String> textFields;
}
