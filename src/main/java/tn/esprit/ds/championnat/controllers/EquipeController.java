package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.services.IEquipeService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/equipe")

@Tag(name = "Gestion Equipe", description = "API pour gérer les équipes du championnat")

public class EquipeController {

    private final IEquipeService equipeService;

    @Operation(
            summary = "Ajouter une équipe",
            description = "Permet d'ajouter une nouvelle équipe avec sa catégorie"
    )
    @ApiResponse(responseCode = "200", description = "Equipe ajoutée avec succès")
    @PostMapping("/add-equipe")
    public Equipe ajouterEquipe(@RequestBody Equipe equipe) {
        return equipeService.ajouterEquipe(equipe);
    }

    @Operation(summary = "Ajouter plusieurs équipes")
    @PostMapping("/add-multiple-equipe")
    public List<Equipe> ajouterEquipes(@RequestBody List<Equipe> equipes) {
        return equipeService.ajouterequipes(equipes);
    }

    @Operation(summary = "Modifier une équipe existante")
    @PutMapping("/update-equipe")
    public Equipe modifierEquipe(@RequestBody Equipe equipe) {
        return equipeService.modifierEquipe(equipe);
    }

    @Operation(summary = "Récupérer toutes les équipes")
    @GetMapping("/get-all-equipe")
    public List<Equipe> listEquipes() {
        return equipeService.listEquipes();
    }

    @Operation(summary = "Supprimer une équipe par ID")
    @DeleteMapping("/delete-equipe/{id}")
    public void supprimerEquipe(
            @Parameter(description = "ID de l'équipe à supprimer")
            @PathVariable Long id) {
        equipeService.supprimerEquipe(id);
    }

    @Operation(summary = "Récupérer une équipe par ID")
    @GetMapping("/get-equipe/{id}")
    public Equipe recupererEquipe(
            @Parameter(description = "ID de l'équipe")
            @PathVariable("id") Long idEquipe) {
        return equipeService.recupererEquipe(idEquipe);
    }


    // 1.1 Historique des contrats d'une équipe
    @GetMapping("/historiqueContratsEquipe/{libelleEquipe}")
    @ResponseBody
    public HashMap<String, Float> historiqueContratsEquipe(
            @PathVariable("libelleEquipe") String libelleEquipe) {
        return equipeService.historiqueContratsEquipe(libelleEquipe);
    }

    // 1.2 Nombre de points des pilotes pour une équipe et une année
    @GetMapping("/nbPointsPilotes/{idEquipe}/{idChampionnat}/{annee}")
    @ResponseBody
    public Integer nbPointsParPilotes(
            @PathVariable("idEquipe") Long idEquipe,
            @PathVariable("idChampionnat") Long idChampionnat,
            @PathVariable("annee") String annee) {
        return equipeService.nbPointsParPilotesUneEquipeChampionnatPourUneAnne(
                idEquipe, idChampionnat, annee);
    }

    // 1.3 Moyenne des positions d'un pilote entre deux dates
    @GetMapping("/moyennePositions/{libelleP}/{startDate}/{endDate}")
    @ResponseBody
    public Float moyennePositions(
            @PathVariable("libelleP") String libelleP,
            @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return equipeService.moyennePositionsEntreDeuxDate(startDate, endDate, libelleP);
    }
}