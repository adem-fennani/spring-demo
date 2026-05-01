package tn.esprit.excham.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.excham.entities.Categorie;
import tn.esprit.excham.entities.Course;
import tn.esprit.excham.services.ICourseService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/course")

public class CourseController {

    ICourseService courseService;
    //http://localhost:8087/cham/course/getCoursesByCategorieForPilote/FORMULA1/1/2025-01-01/2025-12-31
    @GetMapping("/getCoursesByCategorieForPilote/{categorie}/{idPilote}/{startDate}/{endDate}")
    List<String> getCoursesByCategorieForPilote(@PathVariable("categorie") Categorie c, @PathVariable("idPilote") Long idP, @PathVariable("startDate") LocalDate sDate, @PathVariable("endDate") LocalDate eDate)
    {
        return  courseService.getCoursesByCategorieForPilote(c,idP,sDate,eDate);
    }

    //http://localhost:8087/cham/course/listeCoursesParCategoriePourUnPiloteKeyword/FORMULA1/Max Verstappen
    @GetMapping("/listeCoursesParCategoriePourUnPiloteKeyword/{categorie}/{libelleP}")
    List<Course> listeCoursesParCategoriePourUnPiloteKeyword( @PathVariable("categorie") Categorie c, @PathVariable("libelleP") String libelle)
    {
        return  courseService.listeCoursesParCategoriePourUnPiloteKeyword(c,libelle);
    }

    //http://localhost:8087/cham/course/listeCoursesParCategoriePourUnPiloteJPQL/FORMULA1/Max Verstappen
    @GetMapping("/listeCoursesParCategoriePourUnPiloteJPQL/{categorie}/{libelleP}")
    List<Course> listeCoursesParCategoriePourUnPiloteJPQL( @PathVariable("categorie") Categorie c, @PathVariable("libelleP") String libelle)
    {
        return  courseService.listeCoursesParCategoriePourUnPiloteJPQL(c,libelle);
    }


    //http://localhost:8087/cham/course/listeEmplacementsCoursesParCategorieKeyword/FORMULA1
    @GetMapping("/listeEmplacementsCoursesParCategorieKeyword/{categorie}")
    List<String>listeEmplacementsCoursesParCategorieKeyword( @PathVariable("categorie") Categorie c)
    {
        return  courseService.listeEmplacementsCoursesParCategorieKeyword(c);
    }

    //http://localhost:8087/cham/course/listeEmplacementsCoursesParCategorieJPQL/FORMULA1
    @GetMapping("/listeEmplacementsCoursesParCategorieJPQL/{categorie}")
    List<String>listeEmplacementsCoursesParCategorieJPQL( @PathVariable("categorie") Categorie c)
    {
        return  courseService.listeEmplacementsCoursesParCategorieJPQL(c);
    }


    }
