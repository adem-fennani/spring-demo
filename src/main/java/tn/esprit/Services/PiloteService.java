package tn.esprit.Services;

import tn.esprit.Repository.PiloteRepository;
import tn.esprit.entities.Pilote;

public class PiloteService {


    PiloteRepository pi;

    public Pilote ajouterPilote(Pilote pilote){
        return pi.save(pilote);
    }
}
