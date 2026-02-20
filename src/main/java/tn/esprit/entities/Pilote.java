package tn.esprit.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Pilote")
public class Pilote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPilote;

    private String libelleP;
    private Integer nbPointsTotal;
    private Integer classementGeneral;

    @ManyToOne
    @JoinColumn(name="equipe_id")
    private Equipe equipe;

    @OneToMany(mappedBy="pilote")
    private List<Position> positions;
}