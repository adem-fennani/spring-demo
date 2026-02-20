package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repository.ContratRepository;
import tn.esprit.entities.Contrat;

@Service
public class ContratService {

    @Autowired
    ContratRepository contratRepository;

    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }
}
