package by.itransition.mcollections.dto;

import by.itransition.mcollections.entity.Theme;
import by.itransition.mcollections.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowCollectionDto {
    private Integer id;

    private String name;
    private String description;

    private String image;

    private UserDto author;

    private ThemeDto theme;

    private List<String> rowNames = new ArrayList<>();
}
