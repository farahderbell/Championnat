package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PiloteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor

public class PiloteService implements IPiloteService {

    PiloteRepository piloteRepository;
    EquipeRepository equipeRepository;

    @Override
    public String addPilote(Pilote pilote) {
        piloteRepository.save(pilote);
        return "Pilote ajouté : " + pilote.getLibelle();}

    @Override
    public List<Pilote> ajouterPilote(List<Pilote> pilotes) {
        //namlou boucle nsavou bel wehd bel wehd manestamlouch save all
        List<Pilote> piloteSauves = new ArrayList<>();

        for (Pilote s : pilotes) {



            Pilote savedPilote= piloteRepository.save(s);
            piloteSauves.add(savedPilote);
        }

        return piloteSauves;
    }

    @Override
    public Pilote modifierPilote(Pilote pilote) {
        return piloteRepository.save(pilote);
    }

    @Override
    public void supprimerPilote(Long idPilote) {

        if (piloteRepository.existsById(idPilote)) {
            //kadin nabthou ken fel id mouch objet kemel
            //khir men findbyid
            piloteRepository.deleteById(idPilote);
            System.out.println("Sponsor supprimé avec succès !");
        } else {
            System.out.println("Sponsor avec l'id " + idPilote + " n'existe pas.");
        }

    }

    @Override
    public List<Pilote> listPilote() {
        return piloteRepository.findAll();
    }

    @Override
    public Pilote recupererPilote(Long idPilote) {
        if (piloteRepository.existsById(idPilote)) {
            //.get ijib l objet
            return piloteRepository.findById(idPilote).get();
        } else {
            System.out.println("Sponsor avec l'id " + idPilote + " n'existe pas.");
            return null;
        }
    }

    @Override
    public Pilote affecterPiloteToEquipe(String libellePilote, String libelleEquipe) {
        Pilote pilote = piloteRepository.findByLibelle(libellePilote);
        if (pilote == null) {
            throw new RuntimeException("Pilote non trouvé");
        }
        Equipe equipe = equipeRepository.findByLibelle(libelleEquipe);
        if (equipe == null) {
            throw new RuntimeException("Equipe non trouvée");
        }
        pilote.setEquipe(equipe);
        return piloteRepository.save(pilote);
    }

    @Override
    @Scheduled(cron = "0 15 11 31 12 *")
    public void miseAJourPointsEtClassement() {


        int currentYear = LocalDate.now().getYear();
        LocalDate startdate = LocalDate.now();
        LocalDate enddate = startdate.plusDays(1);



        List<Pilote> pilotes = piloteRepository.findAll();

        for (Pilote pilote : pilotes) {

            pilote.setNbPointsTotal(pilote.getNbPointsTotal() + 1);
            piloteRepository.save(pilote);
            int nbPoints = pilote.getNbPointsTotal();



        }




    }
}

