package tn.esprit.excham.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.excham.entities.Categorie;
import tn.esprit.excham.entities.Equipe;
import tn.esprit.excham.entities.Pilote;
import tn.esprit.excham.repositories.EquipeRepository;
import tn.esprit.excham.services.IEquipeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {
    IEquipeService equipeService;



    //http://localhost:8087/cham/equipe/listeEquipesContratSuperieurAXEtPiloteEnTop3/1000
    @GetMapping("/listeEquipesContratSuperieurAXEtPiloteEnTop3/{montant}")
    List<Equipe>listeEquipesContratSuperieurAXEtPiloteEnTop3( @PathVariable("montant") Float montantContrat)
    {
        return  equipeService.listeEquipesContratSuperieurAXEtPiloteEnTop3(montantContrat);
    }

    // http://localhost:8087/cham/equipe/ajoutEquipe
    @PostMapping("/ajoutEquipe")
    @ResponseBody
    public Equipe ajoutEquipe(@RequestBody Equipe eq) {
        return equipeService.ajouterEquipe(eq);
    }
}
