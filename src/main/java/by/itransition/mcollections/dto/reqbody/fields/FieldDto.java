package by.itransition.mcollections.dto.reqbody.fields;

import lombok.Data;

@Data
public class FieldDto<T> {
    private Integer nameId;
    private T value;
}
