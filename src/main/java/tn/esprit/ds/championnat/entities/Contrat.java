package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contrat")




public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private String annee;

    private Float montant;

    private Boolean archived;


    @ManyToOne
    @JoinColumn(name = "equipe_id_equipe")
    private Equipe equipe;


    @ManyToOne
    @JoinColumn(name = "sponsor_id_sponsor")
    private Sponsor sponsor;
}
