package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.DetailChampionnat;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Long> {

    @Query("SELECT c.annee, c.montant FROM Contrat c WHERE c.equipe.libelle = :libelleEquipe")
    List<Object[]> findContratsParEquipe(@Param("libelleEquipe") String libelleEquipe);



}
