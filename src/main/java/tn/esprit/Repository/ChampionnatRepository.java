package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.entities.Championnat;

public interface ChampionnatRepository extends JpaRepository<Championnat, Long> {
}
