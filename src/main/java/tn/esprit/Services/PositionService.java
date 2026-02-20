package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repository.PositionRepository;
import tn.esprit.entities.Position;

@Service
public class PositionService {

    @Autowired
    PositionRepository positionRepository;

    public Position ajouterPosition(Position position) {
        return positionRepository.save(position);
    }
}
