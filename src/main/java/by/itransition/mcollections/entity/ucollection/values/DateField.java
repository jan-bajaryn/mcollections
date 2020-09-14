package by.itransition.mcollections.entity.ucollection.values;

import by.itransition.mcollections.entity.ucollection.Item;
import by.itransition.mcollections.entity.ucollection.names.BoolFieldName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private DateField dateField;

    private LocalDateTime value;

    @ManyToOne
    private Item item;

}
