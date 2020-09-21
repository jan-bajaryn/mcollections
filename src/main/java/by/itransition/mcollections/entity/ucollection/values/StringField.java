package by.itransition.mcollections.entity.ucollection.values;


import by.itransition.mcollections.entity.ucollection.Item;
import by.itransition.mcollections.entity.ucollection.names.BoolFieldName;
import by.itransition.mcollections.entity.ucollection.names.StringFieldName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StringField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private StringFieldName stringFieldName;

    private String value;

    @ManyToOne
    private Item item;

}
