package tn.esprit.Services;

import tn.esprit.Repository.DetailChampionnatRepository;
import tn.esprit.entities.DetailChampionnat;

public class DetailChampionnatService {

    DetailChampionnatRepository detailChampionnatRepository;

    public DetailChampionnat ajouterDetailChampionnat(DetailChampionnat detailChampionnat) {
        return detailChampionnatRepository.save(detailChampionnat);
    }
}
