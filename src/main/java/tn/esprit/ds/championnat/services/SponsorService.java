package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class SponsorService implements ISponsorService{

    private SponsorRepository sponsorRepository;


    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        //
        sponsor.setDateCreation(LocalDate.now());
        sponsor.setArchived(false);
        sponsor.setBloquerContrat(false);
       return sponsorRepository.save(sponsor);

       //or  nejmou na3mlou return sponsor;


    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        //namlou boucle nsavou bel wehd bel wehd manestamlouch save all
        List<Sponsor> sponsorsSauves = new ArrayList<>();

        for (Sponsor s : sponsors) {
            s.setDateCreation(LocalDate.now());
            s.setArchived(false);
            s.setBloquerContrat(false);
            Sponsor savedSponsor = sponsorRepository.save(s);
            sponsorsSauves.add(savedSponsor);
        }

        return sponsorsSauves;
    }


    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        sponsor.setDateDernierModification(LocalDate.now());

        return sponsorRepository.save(sponsor);
    }



    @Override
    public void supprimerSponsor(Long idSponsor) {

        if (sponsorRepository.existsById(idSponsor)) {
            //kadin nabthou ken fel id mouch objet kemel
            //khir men findbyid
            sponsorRepository.deleteById(idSponsor);
            System.out.println("Sponsor supprimé avec succès !");
        } else {
            System.out.println("Sponsor avec l'id " + idSponsor + " n'existe pas.");
        }

    }

    @Override
    public List<Sponsor> listSponsors() {
        //khayba find all djib li meoujoud fel base l kol
        return sponsorRepository.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
        if (sponsorRepository.existsById(idSponsor)) {
            //.get ijib l objet
            return sponsorRepository.findById(idSponsor).get();
        } else {
            System.out.println("Sponsor avec l'id " + idSponsor + " n'existe pas.");
            return null;
        }
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {

        if (sponsorRepository.existsById(idSponsor)) {

        Sponsor s = sponsorRepository.findById(idSponsor).get();

        s.setArchived(true);

        sponsorRepository.save(s);

        System.out.println("Sponsor archivé avec succès !");
        return true;
    } else {
        System.out.println("Sponsor avec l'id " + idSponsor + " n'existe pas.");
        return false;
    }
    }
}
