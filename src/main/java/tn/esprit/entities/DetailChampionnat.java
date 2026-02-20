package tn.esprit.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="DetailChampionnat")
public class DetailChampionnat {
    @Id
    private String code; // PK
    private String description;

    @OneToMany(mappedBy="categorie")
    private List<Championnat> championnats;
}