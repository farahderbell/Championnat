package tn.esprit.ds.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.services.ContratService;

@AllArgsConstructor
@RestController
@RequestMapping("/contrat")

public class ContratController {


    private ContratService contratService;


    @PostMapping("/contrat/ajouter")
    public Contrat ajouterContrat(
            @RequestBody Contrat contrat,
            @RequestParam String libelleEquipe,
            @RequestParam String nomSponsor,
            @RequestParam String pays) {

        return contratService.ajouterContratEtAffecterAEquipeEtSponsor(
                contrat, libelleEquipe, nomSponsor, pays);


    }




}


















































