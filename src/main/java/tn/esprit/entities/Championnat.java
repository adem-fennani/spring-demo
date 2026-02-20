package tn.esprit.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Championnat")
public class Championnat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChampionnat;

    @ManyToOne
    @JoinColumn(name="categorie_code") // FK to DetailChampionnat
    private DetailChampionnat categorie;

    private String libelleC;
    private Integer annee;

    @OneToMany(mappedBy="championnat")
    private List<Course> courses;

    @OneToMany(mappedBy="championnat")
    private List<Equipe> equipes;
}
