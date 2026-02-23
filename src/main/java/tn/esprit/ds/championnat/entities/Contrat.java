package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "contrat")


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idContrat;

     String annee;

     Float montant;

     Boolean archived;


    @ManyToOne
    @JoinColumn(name = "equipe_id_equipe")
    private Equipe equipe;


    @ManyToOne
    @JoinColumn(name = "sponsor_id_sponsor")
    private Sponsor sponsor;
}
