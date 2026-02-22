package tn.esprit.ds.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.IPiloteService;
import tn.esprit.ds.championnat.services.PiloteService;

import java.util.List;

@AllArgsConstructor
@RestController

@RequestMapping("/pilotes")


public class PiloteController {
    PiloteService piloteService;


    @PostMapping("/add-pilote")
    public String addPilote(@RequestBody Pilote pilote) {
        return piloteService.addPilote(pilote);
    }


    @PostMapping("/add-multiple-pilote")
    public List<Pilote> ajouterPilotes(@RequestBody List<Pilote> pilotes) {
        return piloteService.ajouterPilote(pilotes);

    }

    @PutMapping("/update-pilote")
    public Pilote modifierSponsor(@RequestBody Pilote s) {
        return piloteService.modifierPilote(s);
    }


    @GetMapping("/get-all-pilote")
    public List<Pilote> listpilotes() {
        return piloteService.listPilote();}

    @DeleteMapping("/delete-pilote/{id}")
    public void supprimerPilote(@PathVariable Long id) {
        piloteService.supprimerPilote(id);
    }


    @GetMapping("/get-pilote/{id}")
    public Pilote recupererSponsor(@PathVariable("id") Long idPilote) {
        return piloteService.recupererPilote(idPilote);
    }

}