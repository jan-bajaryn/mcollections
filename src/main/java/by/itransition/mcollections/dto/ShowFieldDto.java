package by.itransition.mcollections.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowFieldDto<T> {
    private String name;
    private T value;
}
