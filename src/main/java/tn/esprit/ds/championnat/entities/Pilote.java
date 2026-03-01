package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "pilote")




@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Pilote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idPilote;

     String libelle;

     Integer nbPointsTotal;

     Integer classementGeneral;






    @OneToMany(mappedBy = "pilote")
    private List<Position> positions;

    @ManyToOne
    Equipe equipe;
}
