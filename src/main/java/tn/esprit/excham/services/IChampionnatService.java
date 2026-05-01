package tn.esprit.excham.services;

import tn.esprit.excham.entities.Championnat;

public interface IChampionnatService {
    Championnat addChampionnatAndAssociatedCourses(Championnat championnat);
    String affecterCourseAChampionnat(Long idCourse,Long idChampionnat);
}
