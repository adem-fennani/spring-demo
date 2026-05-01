package tn.esprit.excham.services;

import tn.esprit.excham.entities.DetailChampionnat;

public interface IDetailChampionnatService {

    DetailChampionnat ajouterEtaffecterDetailChampionnatAChampionnat(DetailChampionnat dc, Long idChampionnat);

}
