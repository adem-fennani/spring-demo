package tn.esprit.excham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import tn.esprit.excham.entities.Sponsor;

public interface SponsorRepositor extends JpaRepository<Sponsor,Long> {

}
