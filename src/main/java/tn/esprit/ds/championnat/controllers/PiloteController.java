package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.services.PiloteService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pilotes")

@Tag(name = "Gestion Pilote", description = "API pour gérer les pilotes du championnat")

public class PiloteController {

    private final PiloteService piloteService;

    @Operation(
            summary = "Ajouter un pilote",
            description = "Permet d'ajouter un nouveau pilote avec son classement et ses points"
    )
    @ApiResponse(responseCode = "200", description = "Pilote ajouté avec succès")
    @PostMapping("/add-pilote")
    public String addPilote(@RequestBody Pilote pilote) {
        return piloteService.addPilote(pilote);
    }

    @Operation(summary = "Ajouter plusieurs pilotes")
    @PostMapping("/add-multiple-pilote")
    public List<Pilote> ajouterPilotes(@RequestBody List<Pilote> pilotes) {
        return piloteService.ajouterPilote(pilotes);
    }

    @Operation(summary = "Modifier un pilote existant")
    @PutMapping("/update-pilote")
    public Pilote modifierPilote(@RequestBody Pilote pilote) {
        return piloteService.modifierPilote(pilote);
    }

    @Operation(summary = "Récupérer tous les pilotes")
    @GetMapping("/get-all-pilote")
    public List<Pilote> listPilotes() {
        return piloteService.listPilote();
    }

    @Operation(summary = "Supprimer un pilote par ID")
    @DeleteMapping("/delete-pilote/{id}")
    public void supprimerPilote(
            @Parameter(description = "ID du pilote à supprimer")
            @PathVariable Long id) {
        piloteService.supprimerPilote(id);
    }

    @Operation(summary = "Récupérer un pilote par ID")
    @GetMapping("/get-pilote/{id}")
    public Pilote recupererPilote(
            @Parameter(description = "ID du pilote")
            @PathVariable("id") Long idPilote) {
        return piloteService.recupererPilote(idPilote);
    }

    @Operation(summary = "affecter un pilote a une equipe")
    @PutMapping("/affecter/{libellePilote}/{libelleEquipe}")
    public Pilote affecterPiloteToEquipe(
            @PathVariable String libellePilote,
            @PathVariable String libelleEquipe) {

        return piloteService.affecterPiloteToEquipe(libellePilote, libelleEquipe);
    }

}