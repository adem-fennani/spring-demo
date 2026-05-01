package tn.esprit.excham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.excham.entities.Categorie;
import tn.esprit.excham.entities.Pilote;
import tn.esprit.excham.entities.PiloteDto;

import java.time.LocalDate;
import java.util.List;

public interface PiloteRepository extends JpaRepository<Pilote,Long> {
    Pilote findByLibelleP(String libelle);

    Integer countByCategorie(Categorie c);
    List<Pilote> findByCategorie(Categorie c);

    @Query("select distinct new tn.esprit.excham.entities.PiloteDto(p.libelleP, p.nbPointsTotal, c.libelleC) " +
            "from Pilote p " +
            "join p.positionPilotes position " +
            "join position.course.championnats c " +
            "where c.annee > ?1 and p.classementGeneral = (" +
            " select min(p2.classementGeneral) from Pilote p2 " +
            "          join p2.positionPilotes pos2 " +
            "          join pos2.course.championnats c2 where c2 = c )")
    List<PiloteDto> listeWinners(Integer annee );


    @Query("select distinct new tn.esprit.excham.entities.PiloteDto" +
            "(p.libelleP, p.nbPointsTotal, c.libelleC) " +
            "from Pilote p " +
            "join p.positionPilotes position " +
            "join position.course.championnats c " +
            "where c.annee > ?1 and c.libelleC=?2 and p.classementGeneral = 1")
    PiloteDto winner(Integer annee, String libelleC );





    //@Query("select  sum (distinct p.nbPointsTotal) from Pilote  p join p.equipe eq join p.positionPilotes position join position.course course join course.championnats championnat " +
    //        " where eq.libelleEq =?1 and championnat.libelleC=?2 and championnat.annee = ?3")
    @Query("select  sum(position.nbPoints) from Pilote  p join p.equipe eq join p.positionPilotes position join position.course course join course.championnats championnat " +
            " where eq.libelleEq =?1 and championnat.libelleC=?2 and championnat.annee = ?3")

    Integer nbPointsParPilotesUneEquipeChampionnatCetteAnnee(String libelleEq, String libelleC, String annee);


}
