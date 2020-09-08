package by.itransition.mcollections.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;

    private String image;

    @ManyToOne
    private User author;

    @ManyToOne
    private Theme theme;

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
