package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.entities.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
