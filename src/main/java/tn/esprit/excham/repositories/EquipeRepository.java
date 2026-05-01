package tn.esprit.excham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.excham.entities.Equipe;
import tn.esprit.excham.entities.Sponsor;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    Equipe findByLibelleEq(String libelle);

    //    List<Equipe> listeEquipesContratSuperieurAXEtPiloteEnTop3(Float montantContrat);

    List<Equipe> findByContratsMontantGreaterThanAndPilotesClassementGeneralLessThan(Float montant,  Integer classementGeneral);

}
