package tn.esprit.ds.championnat.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.ContratRepository;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratService implements IContratService{

    ContratRepository contratRepository;
    SponsorRepository sponsorRepository;
    EquipeRepository equipeRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        contrat.setAnnee("2003");
        contrat.setArchived(false);
        contrat.setMontant(1500.5f);
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> ajouterContrats(List<Contrat> contrats) {
        return List.of();
    }

    @Override
    public Contrat modifierContrat(Contrat contrat) {
        return null;
    }

    @Override
    public void supprimerContrat(Long idContrat) {

    }

    @Override
    public List<Contrat> listContrats() {
        return List.of();
    }

    @Override
    public Contrat recupererContrat(Long idContrat) {
        return null;
    }

    @Override
    public Contrat ajouterContratEtAffecterAEquipeEtSponsor(Contrat contrat, String libelleEquipe, String nomSponsor, String pays) {
        Equipe equipe = equipeRepository.findByLibelle(libelleEquipe);
        if (equipe == null) {
            throw new RuntimeException("Equipe non trouvée");
        }

        Sponsor sponsor = sponsorRepository.findByName(nomSponsor);
        if (sponsor == null) {
            throw new RuntimeException("Sponsor non trouvé");
        }
        contrat.setEquipe(equipe);
        contrat.setSponsor(sponsor);
        contrat.setArchived(false); // exemple
        contrat.setMontant(contrat.getMontant());
        contrat.setAnnee(contrat.getAnnee());

        sponsor.setPays(pays);

        return contratRepository.save(contrat);
    }
}
