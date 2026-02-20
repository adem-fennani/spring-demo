package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.entities.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor,Long> {

}
