package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sponsor")




@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idSponsor;

     String nom;

     String pays;

     Float budgetAnnuel;

     Boolean bloquerContrat;

     LocalDate dateCreation;

     boolean archived ;

     LocalDate dateDernierModification;






    @OneToMany(mappedBy = "sponsor")
    private List<Contrat> contrats;
}
