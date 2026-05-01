package tn.esprit.excham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.excham.entities.DetailChampionnat;
import tn.esprit.excham.entities.Sponsor;

public interface DetailChampionnatRepository extends JpaRepository<DetailChampionnat,Long> {

}
