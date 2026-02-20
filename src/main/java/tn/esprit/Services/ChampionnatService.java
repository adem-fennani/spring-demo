package tn.esprit.Services;

import tn.esprit.Repository.ChampionnatRepository;
import tn.esprit.entities.Championnat;

public class ChampionnatService {

    ChampionnatRepository championnatRepository;

    public Championnat ajouterChampionnat(Championnat championnat) {
        return championnatRepository.save(championnat);
    }
}
