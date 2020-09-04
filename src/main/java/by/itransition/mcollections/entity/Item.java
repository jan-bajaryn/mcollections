package by.itransition.mcollections.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "item")
    private List<Tag> tags;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    private List<Like> likes;

    private Boolean bool1;
    private Boolean bool2;
    private Boolean bool3;
    private Integer int1;
    private Integer int2;
    private Integer int3;
    private String string1;
    private String string2;
    private String string3;
    private String text1;
    private String text2;
    private String text3;
    private LocalDateTime date1;
    private LocalDateTime date2;
    private LocalDateTime date3;

    private Integer bitMask;
}
