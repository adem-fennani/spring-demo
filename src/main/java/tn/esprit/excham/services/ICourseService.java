package tn.esprit.excham.services;

import tn.esprit.excham.entities.Categorie;
import tn.esprit.excham.entities.Course;

import java.time.LocalDate;
import java.util.List;

public interface ICourseService {
    List<String> getCoursesByCategorieForPilote(Categorie c, Long idPilote, LocalDate startDate, LocalDate endDate);

    List<Course> listeCoursesParCategoriePourUnPiloteKeyword(Categorie categorie, String libelleP);

    List<Course> listeCoursesParCategoriePourUnPiloteJPQL(Categorie categorie, String libelleP);


    List<String> listeEmplacementsCoursesParCategorieKeyword(Categorie categorie);

    List<String> listeEmplacementsCoursesParCategorieJPQL(Categorie categorie);

    List<String> listeEmplacementsCoursesParCategories(List<Categorie> categories);


}
