package by.itransition.mcollections.entity.ucollection;

import by.itransition.mcollections.entity.Theme;
import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.entity.ucollection.names.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;

    private String image;

    @OneToMany(mappedBy = "uCollection")
    private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Theme theme;

    @OneToMany(mappedBy = "uCollection")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<BoolFieldName> boolFieldNames;
    @OneToMany(mappedBy = "uCollection")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<DateFieldName> dateFieldNames;
    @OneToMany(mappedBy = "uCollection")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<IntFieldName> intFieldNames;
    @OneToMany(mappedBy = "uCollection")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<StringFieldName> stringFieldNames;
    @OneToMany(mappedBy = "uCollection")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<TextFieldName> textFieldNames;

}
