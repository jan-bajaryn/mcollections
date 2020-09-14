package by.itransition.mcollections.dto.reqbody;

import by.itransition.mcollections.entity.ucollection.names.*;
import lombok.Data;

import java.util.List;

//TODO разобраться с переносом с view
@Data
public class UcollectionForCreate {

    private String name;
    private String description;
    private String image;
    private Integer themeId;

    private List<BoolFieldName> boolFieldNames;
    private List<DateFieldName> dateFieldNames;
    private List<IntFieldName> intFieldNames;
    private List<StringFieldName> stringFieldNames;
    private List<TextFieldName> textFieldNames;

}
