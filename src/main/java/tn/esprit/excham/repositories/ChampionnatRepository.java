package tn.esprit.excham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.excham.entities.Championnat;

public interface ChampionnatRepository extends JpaRepository<Championnat,Long> {
}
