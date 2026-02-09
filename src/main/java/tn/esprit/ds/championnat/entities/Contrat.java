package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "contrat")
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private String annee;

    private Float montant;

    private Boolean archived;

    public Contrat() {
    }

    public Long getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(Long idContrat) {
        this.idContrat = idContrat;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }
    @ManyToOne
    @JoinColumn(name = "equipe_id_equipe")
    private Equipe equipe;


    @ManyToOne
    @JoinColumn(name = "sponsor_id_sponsor")
    private Sponsor sponsor;
}
