package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
