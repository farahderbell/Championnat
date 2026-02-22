package tn.esprit.ds.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.services.IEquipeService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/equipe")

public class EquipeController {


    private final IEquipeService equipeService;

    @PostMapping("/add-equipe")
    public Equipe ajouterEquipe(@RequestBody Equipe equipe) {
        return equipeService.ajouterEquipe(equipe);
    }


    @PostMapping("/add-multiple-equipe")
    public List<Equipe> ajouterEquipes(@RequestBody List<Equipe> equipes) {
        return equipeService.ajouterequipes(equipes);

    }

    @PutMapping("/update-equipe")
    public Equipe modifierSponsor(@RequestBody Equipe s) {
        return equipeService.modifierEquipe(s);
    }


    @GetMapping("/get-all-equipe")
    public List<Equipe> listequipes() {
        return equipeService.listEquipes();}

    @DeleteMapping("/delete-equipe/{id}")
    public void supprimerEquipe(@PathVariable Long id) {
        equipeService.supprimerEquipe(id);
    }


    @GetMapping("/get-equipe/{id}")
    public Equipe recupererEquipe(@PathVariable("id") Long idEquipe) {
        return equipeService.recupererEquipe(idEquipe);
    }

    
}
