package tn.esprit.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosition;

    private Integer classement;
    private Integer nbPoints;

    @ManyToOne
    @JoinColumn(name="pilote_id")
    private Pilote pilote;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
}
