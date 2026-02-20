package tn.esprit.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Contrat")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private Float montant;
    private String annee;
    private Boolean archived;

    @ManyToOne
    @JoinColumn(name="sponsor_id")
    private Sponsor sponsor;
}