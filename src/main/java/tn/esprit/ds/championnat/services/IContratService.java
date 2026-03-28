package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.Position;

import java.util.List;

public interface IContratService {

    Position ajouterPosition(Contrat contrat);

    List<Contrat> ajouterContrats(List<Contrat> contrats);

    Contrat modifierContrat(Contrat contrat);

    void supprimerContrat (Long idContrat);

    List<Contrat> listContrats();

    Contrat recupererContrat(Long idContrat);
}
