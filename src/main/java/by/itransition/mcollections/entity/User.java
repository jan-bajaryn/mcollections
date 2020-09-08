package by.itransition.mcollections.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String username;
    @NonNull
    private String password;

    @OneToMany
    private List<UCollection> uCollections;
}
