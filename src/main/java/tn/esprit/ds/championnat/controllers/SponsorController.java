package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.ISponsorService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/sponsor")

@Tag(name = "Gestion Sponsor", description = "API pour gérer les sponsors du championnat")

public class SponsorController {

    private final ISponsorService sponsorService;

    @Operation(
            summary = "Ajouter un sponsor",
            description = "Permet d'ajouter un nouveau sponsor à la base de données"
    )
    @ApiResponse(responseCode = "200", description = "Sponsor ajouté avec succès")
    @PostMapping("/add-sponsor")
    public Sponsor ajouterSponsor(@org.springframework.web.bind.annotation.RequestBody Sponsor s) {
        return sponsorService.ajouterSponsor(s);
    }

    @Operation(summary = "Ajouter plusieurs sponsors")
    @PostMapping("/add-multiple-sponsor")
    public List<Sponsor> ajouterSponsors(@org.springframework.web.bind.annotation.RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    @Operation(summary = "Modifier un sponsor existant")
    @PutMapping("/update-sponsor")
    public Sponsor modifierSponsor(@org.springframework.web.bind.annotation.RequestBody Sponsor s) {
        return sponsorService.modifierSponsor(s);
    }

    @Operation(summary = "Récupérer tous les sponsors")
    @GetMapping("/get-all-sponsor")
    public List<Sponsor> listSponsors() {
        return sponsorService.listSponsors();
    }

    @Operation(summary = "Supprimer un sponsor par ID")
    @DeleteMapping("/delete-sponsor/{id}")
    public void supprimerSponsor(
            @Parameter(description = "ID du sponsor à supprimer")
            @PathVariable Long id) {
        sponsorService.supprimerSponsor(id);
    }

    @Operation(summary = "Récupérer un sponsor par ID")
    @GetMapping("/get-sponsor/{id}")
    public Sponsor recupererSponsor(
            @Parameter(description = "ID du sponsor")
            @PathVariable("id") Long idSponsor) {
        return sponsorService.recupererSponsor(idSponsor);
    }

    @Operation(summary = "Archiver un sponsor")
    @PutMapping("/archive-sponsor/{id}")
    public Boolean archiverSponsor(
            @Parameter(description = "ID du sponsor à archiver")
            @PathVariable("id") Long idSponsor) {
        return sponsorService.archiverSponsor(idSponsor);
    }
}