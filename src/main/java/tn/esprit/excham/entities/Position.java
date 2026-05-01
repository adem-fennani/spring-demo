package tn.esprit.excham.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPosition;
    Integer classement;
    Integer nbPoints;
    @ManyToOne
    Course course;
    @ManyToOne
    Pilote pilote;
}
