package tn.esprit.excham.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.excham.entities.Championnat;
import tn.esprit.excham.entities.Contrat;
import tn.esprit.excham.services.IChampionnatService;

@RestController
@AllArgsConstructor
@RequestMapping("/championnat")

public class ChampionnatController {

IChampionnatService championnatService;
    // http://localhost:8087/cham/championnat/ajoutChampionnatEtCoursesAssocies
    @PostMapping("/ajoutChampionnatEtCoursesAssocies")
    public Championnat ajoutChampionnatEtCoursesAssocies(@RequestBody Championnat c) {
        return championnatService.addChampionnatAndAssociatedCourses(c);
    }

        // http://localhost:8087/cham/championnat/affecterCourseAChampionnat/Red Bull/Oracle/États-Unis
        @PutMapping("/affecterCourseAChampionnat/{libelleEquipe}/{idCourse}/{idChampionnat}")
        @ResponseBody
        public String affecterCourseAChampionnat( @PathVariable("idCourse") Long idCo , @PathVariable("idChampionnat") Long idCh) {
           return  championnatService.affecterCourseAChampionnat(idCo,idCh);
        }
    }