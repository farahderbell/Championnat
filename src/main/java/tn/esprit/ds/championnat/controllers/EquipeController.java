package tn.esprit.ds.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.services.IEquipeService;

@AllArgsConstructor
@RestController
@RequestMapping("/equipe")

public class EquipeController {

    private final IEquipeService equipeService;

    @PostMapping("/add")
    public Equipe ajouterEquipe(@RequestBody Equipe e) {
        return equipeService.ajouterEquipe(e);
    }
}
