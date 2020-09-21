package by.itransition.mcollections.entity.ucollection.values;

import by.itransition.mcollections.entity.ucollection.Item;
import by.itransition.mcollections.entity.ucollection.names.BoolFieldName;
import by.itransition.mcollections.entity.ucollection.names.DateFieldName;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DateField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private DateFieldName dateFieldName;

    private LocalDateTime value;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Item item;

}
