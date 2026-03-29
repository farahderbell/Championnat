package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Contrat;


import java.util.List;

public interface IContratService {

    Contrat ajouterContrat(Contrat contrat);

    List<Contrat> ajouterContrats(List<Contrat> contrats);

    Contrat modifierContrat(Contrat contrat);

    void supprimerContrat (Long idContrat);

    List<Contrat> listContrats();

    Contrat recupererContrat(Long idContrat);

    Contrat ajouterContratEtAffecterAEquipeEtSponsor(Contrat contrat,String libelleEquipe,String nomSponsor,String pays);
}
