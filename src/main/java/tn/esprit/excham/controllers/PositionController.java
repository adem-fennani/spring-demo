package tn.esprit.excham.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.excham.entities.Categorie;
import tn.esprit.excham.entities.Position;
import tn.esprit.excham.services.IPositionService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/position")
public class PositionController {

IPositionService positionService;
    // http://localhost:8087/cham/position/ajoutPosition
    @PostMapping("/ajoutPosition/{idCourse}/{libelleP}")
    @ResponseBody
    public Position ajoutPosition(@RequestBody Position p, @PathVariable("idCourse") Long idCourse, @PathVariable("libelleP")  String libelleP) {
        return positionService.addPositionAndAffectToCourseAndPilote(p,idCourse,libelleP);
    }


    //http://localhost:8087/cham/position/moyennePositionsEntreDeuxDate/2025-01-01/2025-12-31/Max Verstappen
    @GetMapping("/moyennePositionsEntreDeuxDate/{startDate}/{endDate}/{libelleP}")
    Float moyennePositionsEntreDeuxDate(@PathVariable("startDate") LocalDate startD,@PathVariable("endDate") LocalDate endD, @PathVariable("libelleP") String libP)
    {
        return  positionService.moyennePositionsEntreDeuxDate(startD,endD,libP);
    }

}
