package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repository.CourseRepository;
import tn.esprit.entities.Course;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course ajouterCourse(Course course) {
        return courseRepository.save(course);
    }
}
