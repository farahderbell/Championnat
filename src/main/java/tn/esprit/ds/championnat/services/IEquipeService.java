package tn.esprit.ds.championnat.services;

import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Equipe;

@Repository

public interface IEquipeService {
    Equipe ajouterEquipe(Equipe equipe);
}
