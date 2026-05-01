package tn.esprit.excham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.excham.entities.Contrat;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Long> {

    List<Contrat> findByEquipeLibelleEq(String libelleEquipe);
    List<Contrat> findBySponsorNomAndAnneeEquals(String nom, String annee);
    List<Contrat> findByArchived(Boolean archived);
}
