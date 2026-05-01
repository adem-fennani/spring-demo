package tn.esprit.excham.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.excham.entities.Pilote;
import tn.esprit.excham.entities.PiloteDto;
import tn.esprit.excham.services.IPiloteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteController {
    IPiloteService piloteService;
    // http://localhost:8087/cham/pilote/ajoutPilote
    @PostMapping("/ajoutPilote")
    @ResponseBody
    public String ajoutPilote(@RequestBody Pilote p) {
        return piloteService.addPilote(p);
    }

    //http://localhost:8087/cham/pilote/listeWinners/2025
    @GetMapping("/listeWinners/{annee}")
    List<PiloteDto> listeWinners(@PathVariable("annee") Integer annee)
    {
        return  piloteService.listeWinners(annee);
    }



    //http://localhost:8087/cham/pilote/affecterPiloteAEquipe/Lando Norris/McLaren
    @PutMapping("/affecterPiloteAEquipe/{libelleP}/{libelleEq}")
    Pilote affecterPiloteAEquipe(@PathVariable("libelleP") String libellePilote,
                                          @PathVariable("libelleEq") String libellEquipe)
    {
        return  piloteService.affecterPiloteAEquipe(libellePilote,libellEquipe);
    }



    //http://localhost:8087/cham/pilote/nbPointsParPilotesUneEquipeChampionnatPourUneAnnee/1/1/2025
    @GetMapping("/nbPointsParPilotesUneEquipeChampionnatPourUneAnnee/{idEquipe}/{idChampionnat}/{annee}")
    Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnnee(@PathVariable("idEquipe") Long idEq,@PathVariable("idChampionnat") Long idChamp,@PathVariable("annee") String an)
    {
        return  piloteService.nbPointsParPilotesUneEquipeChampionnatPourUneAnnee(idEq,idChamp,an);
    }



}
