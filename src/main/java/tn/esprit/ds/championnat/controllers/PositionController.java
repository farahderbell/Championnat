package tn.esprit.ds.championnat.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.ds.championnat.entities.Position;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.IPositionService;
import tn.esprit.ds.championnat.services.ISponsorService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/position")


public class PositionController {

    private final IPositionService positionService;


    @ApiResponse(responseCode = "200", description = "Position ajouté avec succès")
    @PostMapping("/add-position")
    public Position addPosition(@RequestBody Position position) {
        return positionService.ajouterPosition(position);
    }

    @Operation(summary = "Ajouter plusieurs positions")
    @PostMapping("/add-multiple-position")
    public List<Position> ajouterPositions(@org.springframework.web.bind.annotation.RequestBody List<Position> positions) {
        return positionService.ajouterPositions(positions);
    }

    @Operation(summary = "Modifier un position existant")
    @PutMapping("/update-position")
    public Position modifierPosition(@org.springframework.web.bind.annotation.RequestBody Position s) {
        return positionService.modifierPosition(s);
    }

    @Operation(summary = "Récupérer tous les positions")
    @GetMapping("/get-all-position")
    public List<Position> listPosition() {
        return positionService.listPositions();
    }

    @Operation(summary = "Supprimer un position par ID")
    @DeleteMapping("/delete-position/{id}")
    public void supprimerPosition(
            @Parameter(description = "ID du position à supprimer")
            @PathVariable Long id) {
        positionService.supprimerPosition(id);
    }


    @Operation(summary = "Récupérer un position par ID")
    @GetMapping("/get-position/{id}")
    public Position recupererPosition(
            @Parameter(description = "ID du position")
            @PathVariable("id") Long idPosition) {
        return positionService.recupererPosition(idPosition);
    }

}
