package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Services.SponsorService;
import tn.esprit.entities.Sponsor;

import java.util.List;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    SponsorService sponsorService;

    @PostMapping("/add")
    public Sponsor ajouterSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.ajouterSponsor(sponsor);
    }

    @PostMapping("/addAll")
    public List<Sponsor> ajouterSponsors(@RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    @PutMapping("/update")
    public Sponsor modifierSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.modifierSponsor(sponsor);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerSponsor(@PathVariable("id") Long idSponsor) {
        sponsorService.supprimerSponsor(idSponsor);
    }

    @GetMapping("/all")
    public List<Sponsor> listSponsors() {
        return sponsorService.listSponsors();
    }

    @GetMapping("/{id}")
    public Sponsor recupererSponsor(@PathVariable("id") Long idSponsor) {
        return sponsorService.recupererSponsor(idSponsor);
    }

    @PutMapping("/archive/{id}")
    public Boolean archiverSponsor(@PathVariable("id") Long idSponsor) {
        return sponsorService.archiverSponsor(idSponsor);
    }
}
