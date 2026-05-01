package tn.esprit.excham.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idCourse;
     String emplacement;
     LocalDate dateCourse;
    @ManyToMany(mappedBy = "courses")
     List<Championnat> championnats;
    @OneToMany(mappedBy = "course")
     List<Position> positions;

}
