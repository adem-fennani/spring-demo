package tn.esprit.excham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.excham.entities.Categorie;
import tn.esprit.excham.entities.Pilote;
import tn.esprit.excham.entities.Position;

import java.time.LocalDate;
import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Long> {
    List<Position> findByCourseDateCourseBetweenAndCourseChampionnatsCategorieAndPiloteIdPilote(LocalDate startDate, LocalDate endDate, Categorie categorie,Long idPilote);


    @Query("select avg (position.classement) from Pilote pilote join pilote.positionPilotes position " +
            " join  position.course course where course.dateCourse>= ?1 and course.dateCourse <= ?2 " +
            " and pilote.libelleP= ?3")
    Float moyennePositionsEntreDeuxDate(LocalDate startDate, LocalDate endDate, String libelleP);


    /* List<Position> findByPiloteLibellePAndCourseDateCourseBetween(...)
    double avg = positions.stream()
    .mapToInt(PositionPilote::getClassement)
    .average()
    .orElse(0);
     */

}
