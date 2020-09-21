package by.itransition.mcollections.dto;


import by.itransition.mcollections.dto.reqbody.fields.FieldDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionItem {
    private Integer id;
    private String name;
    private List<String> tags;

    private List<ShowFieldDto<Boolean>> boolFields;
    private List<ShowFieldDto<LocalDateTime>> dateFields;
    private List<ShowFieldDto<Integer>> intFields;
    private List<ShowFieldDto<String>> stringFields;
    private List<ShowFieldDto<String>> textFields;
}
