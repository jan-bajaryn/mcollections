package by.itransition.mcollections.dto.reqbody;

import by.itransition.mcollections.dto.reqbody.fields.FieldDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class ItemCreate {
    private Integer collectionId;
    private String name;
    private List<String> tags;

    private List<FieldDto<Boolean>> boolFields;
    private List<FieldDto<LocalDateTime>> dateFields;
    private List<FieldDto<Integer>> intFields;
    private List<FieldDto<String>> stringFields;
    private List<FieldDto<String>> textFields;
}
