package tn.esprit.excham.services;

import tn.esprit.excham.entities.Contrat;
import tn.esprit.excham.entities.ContratRequestDTO;
import tn.esprit.excham.entities.ContratResponseDTO;

import java.util.HashMap;

public interface IContratService {

    Contrat ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, String libelleEquipe,
                                                   String nomSponsor,String pays);


    void archiverContratsExpireesEtAffichageContratsActifsParEquipe();


    // historique montants contrats d'une équipe

    HashMap<String,Float> historiqueContratsEquipe(String libelleEquipe);

    ContratResponseDTO ajoutContratEtAffecterASponsorEtEquipe(ContratRequestDTO dto, String libelleEquipe, String nomSponsor, String pays);
    ContratResponseDTO ajoutContratEtAffecterASponsorEtEquipeMapper(ContratRequestDTO dto, String libelleEquipe, String nomSponsor, String pays);


}
