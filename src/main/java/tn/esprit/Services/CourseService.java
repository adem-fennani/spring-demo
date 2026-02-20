package tn.esprit.Services;

import tn.esprit.Repository.CourseRepository;
import tn.esprit.entities.Course;

public class CourseService {

    CourseRepository courseRepository;

    public Course ajouterCourse(Course course) {
        return courseRepository.save(course);
    }
}
