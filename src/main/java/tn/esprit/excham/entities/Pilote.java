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
public class Pilote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPilote;
    String libelleP;
    Integer nbPointsTotal;
    Integer classementGeneral;
    @Enumerated(EnumType.STRING)
    Categorie categorie;
    @OneToMany(mappedBy = "pilote",fetch = FetchType.EAGER)
    List<Position> positionPilotes;
    @ManyToOne
    Equipe equipe;
}
