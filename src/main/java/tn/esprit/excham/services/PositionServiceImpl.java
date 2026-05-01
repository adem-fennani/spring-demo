package tn.esprit.excham.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.excham.entities.Course;
import tn.esprit.excham.entities.Pilote;
import tn.esprit.excham.entities.Position;
import tn.esprit.excham.repositories.CourseRepository;
import tn.esprit.excham.repositories.PiloteRepository;
import tn.esprit.excham.repositories.PositionRepository;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements IPositionService{

    PositionRepository positionRepository;
    CourseRepository courseRepository;
    PiloteRepository piloteRepository;
    @Override
    public Position addPositionAndAffectToCourseAndPilote(Position position, Long idCourse, String libelleP) {
        Course course = courseRepository.findById(idCourse).get();
        Pilote pilote = piloteRepository.findByLibelleP(libelleP);

        position.setCourse(course);
        position.setPilote(pilote);
        return positionRepository.save(position);
    }

    @Override
    public Float moyennePositionsEntreDeuxDate(LocalDate startDate, LocalDate endDate, String libelleP) {
        return positionRepository.moyennePositionsEntreDeuxDate(startDate,endDate,libelleP);
    }
}
