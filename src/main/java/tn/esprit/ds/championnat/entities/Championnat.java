package tn.esprit.ds.championnat.entities;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "championnat")
public class Championnat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long IdChampionnat;
    @Enumerated(EnumType.STRING)
    Categorie categorie;
    String LibelleC;
    @Column()
    Integer Annee;

    public Championnat() {
    }

    public Long getIdChampionnat() {
        return this.IdChampionnat;
    }

    public void setIdChampionnat(Long idChampionnat) {
        this.IdChampionnat = idChampionnat;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getLibelleC() {
        return LibelleC;
    }

    public void setLibelleC(String libelleC) {
        this.LibelleC = libelleC;
    }

    public Integer getAnnee() {
        return Annee;
    }

    public void setAnnee(Integer annee) {
        this.Annee = annee;
    }

    @OneToOne
    @JoinColumn(name = "detail_id", referencedColumnName = "idDetail") // clé étrangère
    private DetailChampionnat detail;

    // Many-to-Many vers Course (côté inverse)
    @ManyToMany(mappedBy = "championnats")
    private List<Course> courses;


}
