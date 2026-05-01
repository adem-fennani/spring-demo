package tn.esprit.excham.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.excham.entities.Championnat;
import tn.esprit.excham.entities.DetailChampionnat;
import tn.esprit.excham.repositories.ChampionnatRepository;
import tn.esprit.excham.repositories.DetailChampionnatRepository;

@Service
@AllArgsConstructor
public class DetailChampionnatServiceImpl implements IDetailChampionnatService{
    DetailChampionnatRepository detailChampionnatRepository;
    ChampionnatRepository championnatRepository;

    @Override
    public DetailChampionnat ajouterEtaffecterDetailChampionnatAChampionnat(DetailChampionnat dc, Long idChampionnat) {
        DetailChampionnat detailChampionnat = detailChampionnatRepository.save(dc);
        Championnat championnat = championnatRepository.findById(idChampionnat).orElse(null);
        championnat.setDetailChampionnat(detailChampionnat);
        championnatRepository.save(championnat);

        return detailChampionnat;
    }
}
