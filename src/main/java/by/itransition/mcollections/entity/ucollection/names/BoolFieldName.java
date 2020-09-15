package by.itransition.mcollections.entity.ucollection.names;

import by.itransition.mcollections.entity.ucollection.UCollection;
import by.itransition.mcollections.entity.ucollection.values.BoolField;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoolFieldName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private UCollection uCollection;

    @OneToMany(mappedBy = "boolFieldName")
    private List<BoolField> fields;
}
