package by.itransition.mcollections.entity.ucollection;

import by.itransition.mcollections.entity.MyLike;
import by.itransition.mcollections.entity.Tag;
import by.itransition.mcollections.entity.ucollection.values.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @ManyToOne
    private UCollection uCollection;

    @ManyToMany
    private List<Tag> tags;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    private List<MyLike> myLikes;

    @OneToMany(mappedBy = "item")
    private List<BoolField> boolFields;
    @OneToMany(mappedBy = "item")
    private List<DateField> dateFields;
    @OneToMany(mappedBy = "item")
    private List<IntField> intFields;
    @OneToMany(mappedBy = "item")
    private List<StringField> stringFields;
    @OneToMany(mappedBy = "item")
    private List<TextField> textFields;
}
