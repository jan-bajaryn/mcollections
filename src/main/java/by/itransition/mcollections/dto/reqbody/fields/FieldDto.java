package by.itransition.mcollections.dto.reqbody.fields;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDto<T> {
    private Integer nameId;
    private T value;
}
