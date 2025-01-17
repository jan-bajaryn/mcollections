package by.itransition.mcollections.entity;


import by.itransition.mcollections.entity.ucollection.UCollection;
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
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "theme")
    private List<UCollection> uCollections;
}
