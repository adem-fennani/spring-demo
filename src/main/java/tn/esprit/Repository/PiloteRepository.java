package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.entities.Pilote;

public interface PiloteRepository extends JpaRepository<Pilote,Long> {
}
