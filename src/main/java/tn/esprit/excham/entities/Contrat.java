package tn.esprit.excham.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContrat;
    Float montant;
    String annee;
    Boolean archived;
    @ManyToOne
    private Equipe equipe;
    @ManyToOne
    private Sponsor sponsor;
}
