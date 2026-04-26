package tn.esprit.ds.championnat.services;

import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Repository

public interface IEquipeService {


    Equipe ajouterEquipe(Equipe equipe);



    List<Equipe> ajouterequipes(List<Equipe> equipes);

   Equipe modifierEquipe(Equipe equipe);

    void supprimerEquipe (Long idEquipe);

    List<Equipe> listEquipes();

    Equipe recupererEquipe(Long idEquipe);

    HashMap<String, Float> historiqueContratsEquipe(String libelleEquipe);

    Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(
            Long idEquipe, Long idChampionnat, String annee);

    Float moyennePositionsEntreDeuxDate(
            LocalDate startDate, LocalDate endDate, String libelleP);




}
