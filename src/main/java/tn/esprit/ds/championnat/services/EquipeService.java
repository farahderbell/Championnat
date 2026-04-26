package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.*;
import tn.esprit.ds.championnat.repositories.ContratRepository;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PiloteRepository;
import tn.esprit.ds.championnat.repositories.PositionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
@AllArgsConstructor

public class EquipeService implements IEquipeService {
    EquipeRepository equipeRepository;
    PiloteRepository piloteRepository;
    PositionRepository positionRepository;
    ContratRepository  contratRepository;

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {

        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> ajouterequipes(List<Equipe> equipes) {

        //namlou boucle nsavou bel wehd bel wehd manestamlouch save all
        List<Equipe> equipesSauves = new ArrayList<>();

        for (Equipe s : equipes) {

            Equipe savedEquipe = equipeRepository.save(s);
            equipesSauves.add(savedEquipe);
        }

        return equipesSauves;
    }

    @Override
    public Equipe modifierEquipe(Equipe equipe) {


        return equipeRepository.save(equipe);
    }

    @Override
    public void supprimerEquipe(Long idEquipe) {


        if (equipeRepository.existsById(idEquipe)) {
            //kadin nabthou ken fel id mouch objet kemel
            //khir men findbyid
            equipeRepository.deleteById(idEquipe);
            System.out.println("Sponsor supprimé avec succès !");
        } else {
            System.out.println("Sponsor avec l'id " + idEquipe + " n'existe pas.");
        }
    }

    @Override
    public List<Equipe> listEquipes() {
        //khayba find all djib li meoujoud fel base l kol
        return equipeRepository.findAll();
    }

    @Override
    public Equipe recupererEquipe(Long idEquipe) {

        if (equipeRepository.existsById(idEquipe)) {
            //.get ijib l objet
            return equipeRepository.findById(idEquipe).get();
        } else {
            System.out.println("Sponsor avec l'id " + idEquipe + " n'existe pas.");
            return null;
        }
    }


    // ─── 1.1 Historique des contrats d'une équipe ───
    @Override
    public HashMap<String, Float> historiqueContratsEquipe(String libelleEquipe) {
        HashMap<String, Float> historique = new HashMap<>();
        List<Object[]> results = contratRepository.findContratsParEquipe(libelleEquipe);
        for (Object[] row : results) {
            String annee = (String) row[0];
            Float montant = (Float) row[1];
            historique.put(annee, montant);
        }
        return historique;
    }

    // ─── 1.2 Nombre de points des pilotes d'une équipe pour une année ───
    @Override
    public Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(
            Long idEquipe, Long idChampionnat, String annee) {
        return positionRepository.findNbPointsParEquipeEtChampionnat(
                idEquipe, idChampionnat, annee);
    }

    // ─── 1.3 Moyenne des positions d'un pilote entre deux dates ───
    @Override
    public Float moyennePositionsEntreDeuxDate(
            LocalDate startDate, LocalDate endDate, String libelleP) {
        return positionRepository.findMoyennePositions(libelleP, startDate, endDate);
    }




}
