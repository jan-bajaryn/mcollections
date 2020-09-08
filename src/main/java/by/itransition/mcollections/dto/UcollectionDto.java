package by.itransition.mcollections.dto;

import by.itransition.mcollections.entity.Theme;
import by.itransition.mcollections.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UcollectionDto {

    private Integer id;

    private String name;
    private String description;
    private String image;

    private User author;

    private Theme theme;

}
