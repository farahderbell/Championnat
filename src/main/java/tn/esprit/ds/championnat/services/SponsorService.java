package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SponsorService implements ISponsorService{

    private SponsorRepository sponsorRepository;


    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {

        sponsor.setDateCreation(LocalDate.now());
        sponsor.setArchived(false);
        sponsor.setBloquerContrat(false);
       return sponsorRepository.save(sponsor);

       //or return sponsor;


    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        List<Sponsor> sponsorsSauves = new ArrayList<>();

        for (Sponsor s : sponsors) {
            s.setDateCreation(LocalDate.now());
            s.setArchived(false);
            s.setBloquerContrat(false);
            sponsorsSauves.add(sponsorRepository.save(s));
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
            sponsorRepository.deleteById(idSponsor);
            System.out.println("Sponsor supprimé avec succès !");
        } else {
            System.out.println("Sponsor avec l'id " + idSponsor + " n'existe pas.");
        }

    }

    @Override
    public List<Sponsor> listSponsors() {
        return sponsorRepository.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
        if (sponsorRepository.existsById(idSponsor)) {
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
        s.setArchived(true);  // mettre archived à true
        sponsorRepository.save(s);
        System.out.println("Sponsor archivé avec succès !");
        return true;
    } else {
        System.out.println("Sponsor avec l'id " + idSponsor + " n'existe pas.");
        return false;
    }
    }
}
