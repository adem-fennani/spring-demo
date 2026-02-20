package tn.esprit.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;

    private String libelle;
    private Integer nbPointsTotal;
    private Integer classementGeneral;

    @ManyToOne
    @JoinColumn(name="championnat_id")
    private Championnat championnat;

    @OneToMany(mappedBy="equipe")
    private List<Pilote> pilotes;
}