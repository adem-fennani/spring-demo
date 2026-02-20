package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repository.EquipeRepository;
import tn.esprit.entities.Equipe;

@Service
public class EquipeService {

    @Autowired
    EquipeRepository eq;

    public Equipe ajouterEquipe(Equipe equipe){
        return eq.save(equipe);
    };

}
