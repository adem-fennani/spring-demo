package tn.esprit.Services;

import tn.esprit.Repository.PositionRepository;
import tn.esprit.entities.Position;

public class PositionService {

    PositionRepository positionRepository;

    public Position ajouterPosition(Position position) {
        return positionRepository.save(position);
    }
}
