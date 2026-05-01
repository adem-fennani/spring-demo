package tn.esprit.excham.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.excham.entities.*;
import tn.esprit.excham.services.IContratService;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {
    IContratService contratService;

    // http://localhost:8087/cham/contrat/ajoutContratEtAffecterASponsorEtEquipe/Red Bull/Oracle/États-Unis
    @PostMapping("/ajoutContratEtAffecterASponsorEtEquipe/{libelleEquipe}/{nomSponsor}/{pays}")
    @ResponseBody
    public Contrat ajoutContratEtAffecterASponsorEtEquipe(@RequestBody Contrat contrat
            ,@PathVariable("libelleEquipe") String libelle, @PathVariable("nomSponsor") String nom,
                                                          @PathVariable("pays")  String p) {
        return contratService.ajoutContratEtAffecterASponsorEtEquipe(contrat,libelle,nom,p);
    }



    // http://localhost:8087/cham/contrat/historiqueContratsEquipe/Red Bull

    @GetMapping("/historiqueContratsEquipe/{libelleEquipe}")
    HashMap<String, Float> historiqueContratsEquipe(@PathVariable("libelleEquipe") String libelle)
    {
        return  contratService.historiqueContratsEquipe(libelle);
    }

    @PostMapping("/ajoutContratEtAffecterASponsorEtEquipeDTO/{libelleEquipe}/{nomSponsor}/{pays}")
    public ContratResponseDTO ajoutContratEtAffecterASponsorEtEquipe(
            @RequestBody ContratRequestDTO contratDTO,
            @PathVariable("libelleEquipe") String libelle,
            @PathVariable("nomSponsor") String nom,
            @PathVariable("pays") String p) {

        return contratService.ajoutContratEtAffecterASponsorEtEquipe(
                contratDTO, libelle, nom, p);
    }

    @PostMapping("/ajoutContratEtAffecterASponsorEtEquipeMapper/{libelleEquipe}/{nomSponsor}/{pays}")
    public ContratResponseDTO ajoutContratEtAffecterASponsorEtEquipeMapper(
            @RequestBody ContratRequestDTO contratDTO,
            @PathVariable String libelleEquipe,
            @PathVariable String nomSponsor,
            @PathVariable String pays) {

        return contratService.ajoutContratEtAffecterASponsorEtEquipeMapper(
                contratDTO, libelleEquipe, nomSponsor, pays);
    }

}
