package tn.esprit.excham.services;

import tn.esprit.excham.entities.Pilote;
import tn.esprit.excham.entities.PiloteDto;

import java.util.HashMap;
import java.util.List;

public interface IPiloteService {
    String addPilote(Pilote p);
    List<PiloteDto> listeWinners(Integer annee);
    void updateGeneralClassement();
    HashMap<String, Float> top3Pilotes(String libelleC);
    Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnnee(Long idEquipe, Long idChampionnat, String annee);
    Pilote affecterPiloteAEquipe(String libelleP, String libelleEq);

}
