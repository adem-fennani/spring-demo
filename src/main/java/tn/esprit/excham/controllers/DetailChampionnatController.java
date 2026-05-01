package tn.esprit.excham.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.excham.entities.DetailChampionnat;
import tn.esprit.excham.entities.Pilote;
import tn.esprit.excham.services.IDetailChampionnatService;

@RestController
@AllArgsConstructor
@RequestMapping("/detailChampionnat")

public class DetailChampionnatController {

    IDetailChampionnatService detailChampionnatService;

//DetailChampionnat (DetailChampionnat dc, Long idChampionnat)


    // http://localhost:8087/cham/detailChampionnat/ajouterEtaffecterDetailChampionnatAChampionnat/1
    @PostMapping("/ajouterEtaffecterDetailChampionnatAChampionnat/{idChampionnat}")
    @ResponseBody
    public DetailChampionnat ajouterEtaffecterDetailChampionnatAChampionnat(@RequestBody DetailChampionnat dt, @PathVariable("idChampionnat") Long id) {
        return detailChampionnatService.ajouterEtaffecterDetailChampionnatAChampionnat(dt,id);
    }
}
