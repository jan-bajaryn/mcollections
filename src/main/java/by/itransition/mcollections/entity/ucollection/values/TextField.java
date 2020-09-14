package by.itransition.mcollections.entity.ucollection.values;


import by.itransition.mcollections.entity.ucollection.Item;
import by.itransition.mcollections.entity.ucollection.names.TextFieldName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private TextFieldName textFieldName;

    private String value;

    @ManyToOne
    private Item item;
}
