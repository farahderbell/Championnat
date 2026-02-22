package tn.esprit.ds.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.ISponsorService;

import java.util.List;

@AllArgsConstructor
@RestController

@RequestMapping("/sponsor")



public class SponsorController {
    private final ISponsorService sponsorService;

    @PostMapping("/add-sponsor")
    public Sponsor ajouterSponsor(@RequestBody Sponsor s) {
        return sponsorService.ajouterSponsor(s);
    }

    @PostMapping("/add-multiple-sponsor")
    public List<Sponsor> ajouterSponsors(@RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    @PutMapping("/update-sponsor")
    public Sponsor modifierSponsor(@RequestBody Sponsor s) {
        return sponsorService.modifierSponsor(s);
    }

    @GetMapping("/get-all-sponsor")
    public List<Sponsor> listSponsors() {
        return sponsorService.listSponsors();}

    @DeleteMapping("/delete-sponsor/{id}")
    public void supprimerSponsor(@PathVariable Long id) {
        sponsorService.supprimerSponsor(id);
    }

    @GetMapping("/get-sponsor/{id}")
    public Sponsor recupererSponsor(@PathVariable("id") Long idSponsor) {
        return sponsorService.recupererSponsor(idSponsor);
    }

    @PutMapping("/archive-sponsor/{id}")
    public Boolean archiverSponsor(@PathVariable("id") Long idSponsor) {
        return sponsorService.archiverSponsor(idSponsor);
    }
}