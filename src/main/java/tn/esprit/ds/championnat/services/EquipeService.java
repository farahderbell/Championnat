package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.EquipeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor

public class EquipeService implements IEquipeService {
    EquipeRepository equipeRepository;

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
}
