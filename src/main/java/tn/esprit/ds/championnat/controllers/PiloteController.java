package tn.esprit.ds.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.services.IPiloteService;
import tn.esprit.ds.championnat.services.PiloteService;

import java.util.List;

@AllArgsConstructor
@RestController

@RequestMapping("/Pilote")


public class PiloteController {
    PiloteService piloteService;

    public String addPilote(@RequestBody Pilote p) {

        return piloteService.addPilote(p);
    }

}