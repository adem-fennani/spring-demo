package tn.esprit.excham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.excham.entities.Pilote;
import tn.esprit.excham.entities.Sponsor;

import java.util.List;


public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
    Sponsor findByNomAndPays(String nom, String pays);
}
