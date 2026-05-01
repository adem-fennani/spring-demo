package tn.esprit.excham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.excham.entities.Categorie;
import tn.esprit.excham.entities.Championnat;
import tn.esprit.excham.entities.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findDistinctByChampionnatsCategorieAndPositionsPiloteIdPiloteAndDateCourseBetween
            (Categorie categorie, Long idPilote, LocalDate startDate,LocalDate endDate);

    List<Course> findByChampionnatsCategorieAndPositionsPiloteLibelleP(Categorie categorie,
                                                                       String libelleP);

    @Query("select course from Course course join  course.championnats champ join course.positions position join " +
            " position.pilote pilote where champ.categorie = ?1 and pilote.libelleP=?2")
    List<Course> listeCoursesParCategoriePourUnPilote(Categorie c, String libelleP);


    //

    List<Course> findByChampionnatsCategorie(Categorie categorie);

    @Query("select c.emplacement from Course c join  c.championnats champ where " +
            " champ.categorie =:cat")
    List<String>listeEmplacementsCoursesParCategorie(@Param("cat") Categorie categorie);

}
