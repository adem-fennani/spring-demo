package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Services.ChampionnatService;

@RestController
public class ChampionnatController {

    @Autowired
    ChampionnatService championnatService;
}
