package by.itransition.mcollections.dto.reqbody;

import by.itransition.mcollections.entity.Theme;
import by.itransition.mcollections.entity.User;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class UcollectionForCreate {

    private String name;
    private String description;
    private String image;
    private Integer themeId;
    private String bool1Name;
    private String bool2Name;
    private String bool3Name;
    private String int1Name;
    private String int2Name;
    private String int3Name;
    private String string1Name;
    private String string2Name;
    private String string3Name;
    private String text1Name;
    private String text2Name;
    private String text3Name;
    private String date1Name;
    private String date2Name;
    private String date3Name;

}
