package tn.esprit.ds.championnat.services;

import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.entities.Sponsor;

import java.util.List;

@Repository

public interface IEquipeService {


    Equipe ajouterEquipe(Equipe equipe);



    List<Equipe> ajouterequipes(List<Equipe> equipes);

   Equipe modifierEquipe(Equipe equipe);

    void supprimerEquipe (Long idEquipe);

    List<Equipe> listEquipes();

    Equipe recupererEquipe(Long idEquipe);



}
