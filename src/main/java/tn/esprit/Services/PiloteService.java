package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repository.PiloteRepository;
import tn.esprit.entities.Pilote;

@Service
public class PiloteService {

    @Autowired
    PiloteRepository pi;

    public Pilote ajouterPilote(Pilote pilote){
        return pi.save(pilote);
    }
}
