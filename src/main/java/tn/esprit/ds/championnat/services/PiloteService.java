package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.PiloteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor

public class PiloteService implements IPiloteService {

    PiloteRepository piloteRepository;

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
}
