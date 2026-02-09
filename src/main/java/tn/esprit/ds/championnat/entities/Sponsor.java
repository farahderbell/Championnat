package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sponsor")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSponsor;

    private String nom;

    private String pays;

    private Float budgetAnnuel;

    private Boolean bloquerContrat;

    private LocalDate dateCreation;

    private boolean archived ;

    private LocalDate dateDernierModification;


    public Sponsor() {
    }

    public Long getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(Long idSponsor) {
        this.idSponsor = idSponsor;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Float getBudgetAnnuel() {
        return budgetAnnuel;
    }

    public void setBudgetAnnuel(Float budgetAnnuel) {
        this.budgetAnnuel = budgetAnnuel;
    }

    public Boolean getBloquerContrat() {
        return bloquerContrat;
    }

    public void setDateCreation(LocalDate  dateCreation) {this.dateCreation = dateCreation;}
    public LocalDate getDateCreation() {return dateCreation;}

    public void setDateDernierModification (LocalDate dateCreation){this.dateDernierModification = dateCreation;}
    public LocalDate getDateDernierModification() {return dateDernierModification;}

    public void setArchived(boolean archived) {this.archived = archived;}
    public boolean getArchived() {return archived;}

    public void setBloquerContrat(Boolean bloquerContrat) {
        this.bloquerContrat = bloquerContrat;
    }
    @OneToMany(mappedBy = "sponsor")
    private List<Contrat> contrats;
}
