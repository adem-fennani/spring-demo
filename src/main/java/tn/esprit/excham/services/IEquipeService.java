package tn.esprit.excham.services;

import tn.esprit.excham.entities.Equipe;

import java.util.List;

public interface IEquipeService {

    // liste des équipes qui ont un contrat dont le montant dépasse x et qui ont un pilote dont le
    // classement général est dans le top 3

    List<Equipe> listeEquipesContratSuperieurAXEtPiloteEnTop3(Float montantContrat);
    Equipe ajouterEquipe(Equipe equipe);
}
