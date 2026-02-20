package tn.esprit.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idCourse;
     String emplacement;
     LocalDate dateCourse;

    @ManyToOne
    @JoinColumn(name="championnat_id")
     Championnat championnat;

    @OneToMany(mappedBy="course")
     List<Position> positions;


}
