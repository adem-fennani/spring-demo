package tn.esprit.excham.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.excham.entities.Pilote;
import tn.esprit.excham.entities.Sponsor;
import tn.esprit.excham.services.ISponsorService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sponsor")
public class SponsorController {
    private ISponsorService sponsorService;

    // http://localhost:8087/cham/sponsor/ajoutSponsor
    @PostMapping("/ajoutSponsor")
    @ResponseBody
    public Sponsor ajoutSponsor(@RequestBody Sponsor s) {
        return sponsorService.ajouterSponsor(s);
    }


    // http://localhost:8087/cham/sponsor/ajoutSponsors
    @PostMapping("/ajoutSponsors")
    @ResponseBody
    public  List<Sponsor> ajoutSponsors(@RequestBody  List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }



    // http://localhost:8087/cham/sponsor/modifierSponsor
    @PutMapping("/modifierSponsor")
    @ResponseBody
    public Sponsor modifierSponsor(@RequestBody Sponsor s) {
        return sponsorService.modifierSponsor(s);
    }




    // http://localhost:8087/cham/sponsor/listeSponsors
    @GetMapping("/listeSponsors")
    @ResponseBody
    public List<Sponsor> listeSponsors(){
        return  sponsorService.listSponsors();
    }


    // http://localhost:8087/cham/sponsor/supprimerSponsor/4
    @DeleteMapping("/supprimerSponsor/{idSponsor}")
    void supprimerSponsor(@PathVariable("idSponsor") Long id) {
        sponsorService.supprimerSponsor(id);
    }


    // http://localhost:8087/cham/sponsor/recupererSponsor/1
    @GetMapping("/recupererSponsor/{idSponsor}")
    @ResponseBody
    public Sponsor recupererSponsor(@PathVariable("idSponsor") Long id){
        return  sponsorService.recupererSponsor(id);
    }

    // http://localhost:8087/cham/sponsor/archiverSponsor/4
    @PutMapping("/archiverSponsor/{idSponsor}")
    @ResponseBody
    public Boolean archiverSponsor(@PathVariable("idSponsor") Long id) {

        return sponsorService.archiverSponsor(id);
    }


    // http://localhost:8087/cham/sponsor/pourcentageBudgetAnnuelConsomme/1
    @GetMapping("/pourcentageBudgetAnnuelConsomme/{idSponsor}")
    @ResponseBody
    public Float pourcentageBudgetAnnuelConsomme(@PathVariable("idSponsor") Long id){
        return  sponsorService.pourcentageBudgetAnnuelConsomme(id);
    }

}
