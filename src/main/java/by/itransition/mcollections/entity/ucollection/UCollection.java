package by.itransition.mcollections.entity.ucollection;

import by.itransition.mcollections.entity.Theme;
import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.entity.ucollection.names.*;
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

    @OneToMany(mappedBy = "uCollection")
    private List<BoolFieldName> boolFieldNames;
    @OneToMany(mappedBy = "uCollection")
    private List<DateFieldName> dateFieldNames;
    @OneToMany(mappedBy = "uCollection")
    private List<IntFieldName> intFieldNames;
    @OneToMany(mappedBy = "uCollection")
    private List<StringFieldName> stringFieldNames;
    @OneToMany(mappedBy = "uCollection")
    private List<TextFieldName> textFieldNames;

}
