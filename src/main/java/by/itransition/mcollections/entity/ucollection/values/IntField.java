package by.itransition.mcollections.entity.ucollection.values;


import by.itransition.mcollections.entity.ucollection.Item;
import by.itransition.mcollections.entity.ucollection.names.BoolFieldName;
import by.itransition.mcollections.entity.ucollection.names.IntFieldName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private IntFieldName intFieldName;

    private Integer value;

    @ManyToOne
    private Item item;
}
