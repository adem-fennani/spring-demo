package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Services.DetailChampionnatService;
import tn.esprit.entities.DetailChampionnat;

@RestController
public class DetailChampionnatController {

    @Autowired
    DetailChampionnatService detailChampionnatService;

    public DetailChampionnat ajouterDetailChampionnat(DetailChampionnat detailChampionnat) {
        return detailChampionnatService.ajouterDetailChampionnat(detailChampionnat);
    }
}
