package tn.esprit.ds.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.ISponsorService;

import java.util.List;

@AllArgsConstructor
@RestController




public class SponsorController {
    private final ISponsorService sponsorService;

    @PostMapping("/add")
    public Sponsor ajouterSponsor(@RequestBody Sponsor s) {
        return sponsorService.ajouterSponsor(s);
    }

    @PostMapping("/add-multiple")
    public List<Sponsor> ajouterSponsors(@RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    @PutMapping("/update")
    public Sponsor modifierSponsor(@RequestBody Sponsor s) {
        return sponsorService.modifierSponsor(s);
    }

    @GetMapping("/get-all")
    public List<Sponsor> listSponsors() {
        return sponsorService.listSponsors();

    }
}