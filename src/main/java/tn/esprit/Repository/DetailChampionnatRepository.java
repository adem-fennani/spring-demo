package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.entities.DetailChampionnat;

public interface DetailChampionnatRepository extends JpaRepository<DetailChampionnat, String> {
}
