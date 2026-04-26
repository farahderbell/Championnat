package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.ds.championnat.entities.Position;

import java.time.LocalDate;

public interface PositionRepository extends JpaRepository<Position, Long> {

    // ─── 1.2 Fix : JOIN sur la liste championnats ───
    @Query("SELECT SUM(pos.nbPoints) FROM Position pos " +
            "JOIN pos.course.championnats c " +
            "WHERE pos.pilote.equipe.idEquipe = :idEquipe " +
            "AND c.IdChampionnat = :idChampionnat " +
            "AND c.Annee = :annee")
    Integer findNbPointsParEquipeEtChampionnat(
            @Param("idEquipe") Long idEquipe,
            @Param("idChampionnat") Long idChampionnat,
            @Param("annee") String annee);

    // ─── 1.3 Fix : libelleP est un String pas un id ───
    @Query("SELECT AVG(pos.classement) FROM Position pos " +
            "WHERE pos.pilote.idPilote = :libelleP " +
            "AND pos.course.dateCourse BETWEEN :startDate AND :endDate")
    Float findMoyennePositions(
            @Param("libelleP") String libelleP,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
