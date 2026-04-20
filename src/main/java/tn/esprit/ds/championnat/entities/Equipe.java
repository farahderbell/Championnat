package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "equipe")



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idEquipe;

     String libelle;

     Integer nbPointsTotal;

     Integer classementGeneral;






    @OneToMany(mappedBy = "equipe")
    private List<Pilote> pilotes;

    @OneToMany(mappedBy = "equipe" , fetch = FetchType.EAGER)
    private List<Contrat> contrats;
}
