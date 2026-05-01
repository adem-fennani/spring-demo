package tn.esprit.excham.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.excham.entities.Categorie;
import tn.esprit.excham.entities.Course;
import tn.esprit.excham.repositories.CourseRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService{

    CourseRepository courseRepository;
    @Override
    public List<String> getCoursesByCategorieForPilote(Categorie c, Long idPilote, LocalDate startDate, LocalDate endDate) {
        List<Course> courses = courseRepository.findDistinctByChampionnatsCategorieAndPositionsPiloteIdPiloteAndDateCourseBetween(c,idPilote,startDate,endDate);
        List<String> results = new ArrayList<>();
        courses.stream().forEach(course ->
                results.add(course.getEmplacement()));
        return results;
    }

    @Override
    public List<Course> listeCoursesParCategoriePourUnPiloteKeyword(Categorie categorie, String libelleP) {
        return courseRepository.findByChampionnatsCategorieAndPositionsPiloteLibelleP(categorie,libelleP);
    }

    @Override
    public List<Course> listeCoursesParCategoriePourUnPiloteJPQL(Categorie categorie, String libelleP) {
        return courseRepository.listeCoursesParCategoriePourUnPilote(categorie,libelleP);
    }

    @Override
    public List<String> listeEmplacementsCoursesParCategorieKeyword(Categorie categorie) {
        List<String> emplacements = new ArrayList<>();
        List<Course> courses = courseRepository.findByChampionnatsCategorie(categorie);
        courses.forEach(course -> {
            emplacements.add(course.getEmplacement());
        });
        return emplacements;
    }
    @Override
    public List<String> listeEmplacementsCoursesParCategorieJPQL(Categorie categorie) {
        return courseRepository.listeEmplacementsCoursesParCategorie(categorie);
    }

    @Override
    public List<String> listeEmplacementsCoursesParCategories(List<Categorie> categories) {
        return List.of();
    }


}
