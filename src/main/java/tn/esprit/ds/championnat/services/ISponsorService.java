package tn.esprit.ds.championnat.services;

import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Sponsor;

import java.util.List;


@Repository
public interface ISponsorService {

    Sponsor ajouterSponsor(Sponsor sponsor);

    List<Sponsor> ajouterSponsors(List<Sponsor> sponsors);

    Sponsor modifierSponsor(Sponsor sponsor);

    void supprimerSponsor (Long idSponsor);

    List<Sponsor> listSponsors();

    Sponsor recupererSponsor(Long idSponsor);

    Boolean archiverSponsor(Long idSponsor);

}
