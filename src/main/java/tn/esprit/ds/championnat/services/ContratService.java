package tn.esprit.ds.championnat.services;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.*;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.repositories.ContratRepository;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ContratService implements IContratService {

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

        Sponsor sponsor = sponsorRepository.findByNom(nomSponsor);
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

    @Transactional
    @Override
    @Scheduled(fixedRate = 30000)
    public void archiverContratsExpireesEtAffichageContratsActifsParEquipe() {

        log.info("test");
        System.out.println("test");
        int currentYear = LocalDate.now().getYear();

        List<Contrat> contrats = contratRepository.findAll();

        for (Contrat c : contrats) {
            int anneeContrat = Integer.parseInt(c.getAnnee());

            if (anneeContrat < currentYear) {
                c.setArchived(true);
                contratRepository.save(c);
            }

            List<Equipe> equipes = equipeRepository.findAll();

            for (Equipe e : equipes) {

                List<Contrat> contratsEquipe = e.getContrats();

                if (contratsEquipe != null) {
                    for (Contrat contrat : contratsEquipe) {

                        if (!Boolean.TRUE.equals(c.getArchived())) {

                            System.out.println("L'équipe " + e.getLibelle() +
                                    " a un contrat de l'année " + contrat.getAnnee() +
                                    " d'un montant de " + contrat.getMontant() +
                                    " avec le sponsor " + contrat.getSponsor().getNom());
                        }
                    }
                }
            }





        }
    }




}