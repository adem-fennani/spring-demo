package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repository.ChampionnatRepository;
import tn.esprit.entities.Championnat;

@Service
public class ChampionnatService {

    @Autowired
    ChampionnatRepository championnatRepository;

    public Championnat ajouterChampionnat(Championnat championnat) {
        return championnatRepository.save(championnat);
    }
}
