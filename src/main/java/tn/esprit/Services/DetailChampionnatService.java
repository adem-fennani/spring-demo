package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repository.DetailChampionnatRepository;
import tn.esprit.entities.DetailChampionnat;

@Service
public class DetailChampionnatService {

    @Autowired
    DetailChampionnatRepository detailChampionnatRepository;

    public DetailChampionnat ajouterDetailChampionnat(DetailChampionnat detailChampionnat) {
        return detailChampionnatRepository.save(detailChampionnat);
    }
}
