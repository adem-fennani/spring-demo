package tn.esprit.excham.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.excham.entities.Equipe;
import tn.esprit.excham.repositories.EquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService{
    EquipeRepository equipeRepository;
    @Override
    public List<Equipe> listeEquipesContratSuperieurAXEtPiloteEnTop3(Float montantContrat) {
        return equipeRepository.findByContratsMontantGreaterThanAndPilotesClassementGeneralLessThan(montantContrat,4);
    }

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        equipe.setClassementGeneral(0);
        equipe.setNbPointsTotal(0);
        return equipeRepository.save(equipe);
    }
}
