package tn.esprit.excham.services;

import tn.esprit.excham.entities.Position;

import java.time.LocalDate;

public interface IPositionService {
    Position addPositionAndAffectToCourseAndPilote(Position position, Long idCourse, String libelleP);

    // moyenne des positions occupées par un pilote entre deux dates
    Float moyennePositionsEntreDeuxDate(LocalDate startDate, LocalDate endDate, String libelleP);
}
