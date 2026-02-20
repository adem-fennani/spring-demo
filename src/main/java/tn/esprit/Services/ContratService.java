package tn.esprit.Services;

import tn.esprit.Repository.ContratRepository;
import tn.esprit.entities.Contrat;

public class ContratService {

    ContratRepository contratRepository;

    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }
}
