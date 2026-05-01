package tn.esprit.excham.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipe;
    String libelleEq;
    Integer nbPointsTotal;
    Integer classementGeneral;
    @OneToMany(mappedBy = "equipe")
    List<Pilote> pilotes;
    @OneToMany(mappedBy = "equipe",fetch = FetchType.EAGER)
    List<Contrat> contrats;

}
