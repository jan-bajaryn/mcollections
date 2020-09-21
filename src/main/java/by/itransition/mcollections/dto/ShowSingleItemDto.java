package by.itransition.mcollections.dto;

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
public class ShowSingleItemDto {

    private Integer id;
    private Integer collectionId;
    private String image;
    private String name;
    private List<String> tags;

    private List<ShowFieldDto<Boolean>> boolFields;
    private List<ShowFieldDto<LocalDateTime>> dateFields;
    private List<ShowFieldDto<Integer>> intFields;
    private List<ShowFieldDto<String>> stringFields;
    private List<ShowFieldDto<String>> textFields;

}
