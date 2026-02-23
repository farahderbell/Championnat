package tn.esprit.ds.championnat.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@Table(name = "championnat")





@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Championnat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long IdChampionnat;

    @Enumerated(EnumType.STRING)
     Categorie categorie;

     String LibelleC;
    @Column()
     Integer Annee;




    @OneToOne
    @JoinColumn(name = "detail_id", referencedColumnName = "idDetail") // clé étrangère
    private DetailChampionnat detail;

    // Many-to-Many vers Course (côté inverse)
    @ManyToMany(mappedBy = "championnats")
    private List<Course> courses;


}
