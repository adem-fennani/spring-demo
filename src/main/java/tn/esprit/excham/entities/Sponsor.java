package tn.esprit.excham.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSponsor;
    String nom;
    String pays;
    Float  budgetAnnuel;
    Boolean bloquerContrat;
    @OneToMany
    private List<Contrat> contrats;
    Boolean archived;
    LocalDate dateCreation;
    LocalDate dateDerniereModification;

}
