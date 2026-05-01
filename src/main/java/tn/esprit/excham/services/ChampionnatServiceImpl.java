package tn.esprit.excham.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.excham.entities.Categorie;
import tn.esprit.excham.entities.Championnat;
import tn.esprit.excham.entities.Course;
import tn.esprit.excham.repositories.ChampionnatRepository;
import tn.esprit.excham.repositories.CourseRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ChampionnatServiceImpl implements IChampionnatService{
    ChampionnatRepository championnatRepository;
    CourseRepository courseRepository;
    @Override
    public Championnat addChampionnatAndAssociatedCourses(Championnat championnat) {
       // System.out.println("start method addChampionnatAndAssociatedCourses");
       //  Championnat c = new Championnat(1, Categorie.MOTOGP,"a",2026,null,null, LocalDate.now());
        Championnat c2 = Championnat.builder()
                                    .libelleC("motogp")
                                    .categorie(Categorie.FORMULA1)
                                    .build();
        log.error("start method addChampionnatAndAssociatedCourses");

        return championnatRepository.save(championnat);
    }

    @Override
    public String affecterCourseAChampionnat(Long idCourse, Long idChampionnat) {
        Course course = courseRepository.findById(idCourse).orElse(null);
        Championnat championnat = championnatRepository.findById(idChampionnat).orElse(null);
        List<Course> courses = new ArrayList<>();
        if(championnat.getCourses()!=null){
            courses.addAll(championnat.getCourses());
        }
        courses.add(course);
        championnat.setCourses(courses);
        championnatRepository.save(championnat);
        return "affectation réalisé avec succès";
    }
}
