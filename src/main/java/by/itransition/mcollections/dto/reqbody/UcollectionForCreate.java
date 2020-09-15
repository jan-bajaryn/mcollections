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

    private List<String> boolFieldNames;
    private List<String> dateFieldNames;
    private List<String> intFieldNames;
    private List<String> stringFieldNames;
    private List<String> textFieldNames;

}
