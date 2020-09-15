package by.itransition.mcollections.entity.ucollection.names;

import by.itransition.mcollections.entity.ucollection.UCollection;
import by.itransition.mcollections.entity.ucollection.values.BoolField;
import by.itransition.mcollections.entity.ucollection.values.StringField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StringFieldName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private UCollection uCollection;

    @OneToMany(mappedBy = "stringFieldName")
    private List<StringField> fields;

}
