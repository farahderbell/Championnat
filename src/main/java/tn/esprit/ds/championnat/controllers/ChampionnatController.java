package tn.esprit.ds.championnat.controllers;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Championnat;

import tn.esprit.ds.championnat.entities.DetailChampionnat;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.services.ChampionnatService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/championnat-gestion")




public class ChampionnatController {

    private final ChampionnatService championnatService;
    // houni l ajout bel CASCAD
    @ApiResponse(responseCode = "200", description = "championnat ajoutée avec succès")
    @PostMapping("/add-championnat")
    @ResponseBody
    public Championnat ajouterEquipe(@RequestBody Championnat championnat) {
        return championnatService.addChampionnatEtDetails(championnat);
    }
    // houni ana l championnat o kadin naffecteou fel details
    @PutMapping("/affecterDetailToChampionnat/{idChampionnat}")
    @ResponseBody

    public Championnat affecterDetailToChampionnat(
            @RequestBody DetailChampionnat detail,
            @PathVariable("idChampionnat") Long idChampionnat) {
        return championnatService.affecterDetailsToChampionnat(detail, idChampionnat);
    }

    @GetMapping("/get-all-championnat")
    @ResponseBody

    public List<Championnat> listchampionnat() {
        return championnatService.listChampionnat();
    }

    @PutMapping("/affectercourseToChampionnat/{idCourse}/{idChampionnat}")
    @ResponseBody

    public void affectercourseToChampionnat(@PathVariable("idCourse") Long idCourse,
                                            @PathVariable("idChampionnat") Long idChampionnat) {
        championnatService.affecterCourseToChampionnat(idCourse, idChampionnat);

    }

}
