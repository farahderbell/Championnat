package tn.esprit.ds.championnat.services;

import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Sponsor;

import java.util.List;

@Repository

public interface IPiloteService {
    String addPilote (Pilote pilote);
    List<Pilote> ajouterPilote(List<Pilote> pilotes);

    Pilote modifierPilote(Pilote pilote);

    void supprimerPilote (Long idPilote);

    List<Pilote> listPilote();

    Pilote recupererPilote(Long idPilote);
}
