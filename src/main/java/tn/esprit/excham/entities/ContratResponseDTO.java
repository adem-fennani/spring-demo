package tn.esprit.excham.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContratResponseDTO {

    private Long idContrat;
    private Float montant;
    private String annee;

    private String libelleEquipe;
    private String nomSponsor;
}

