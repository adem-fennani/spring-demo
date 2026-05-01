package tn.esprit.excham.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.excham.entities.*;
import tn.esprit.excham.repositories.ChampionnatRepository;
import tn.esprit.excham.repositories.EquipeRepository;
import tn.esprit.excham.repositories.PiloteRepository;
import tn.esprit.excham.repositories.PositionRepository;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class PiloteServiceImpl implements IPiloteService{
    PiloteRepository piloteRepository;
    EquipeRepository equipeRepository;
    ChampionnatRepository championnatRepository;
    PositionRepository positionRepository;
    @Override
    public String addPilote(Pilote p) {
        p.setNbPointsTotal(0);
        p.setClassementGeneral(0);
        piloteRepository.save(p);
        return p.getLibelleP();
    }
    @Override
    public List<PiloteDto> listeWinners(Integer annee) {
        List<PiloteDto> results = new ArrayList<>();
        championnatRepository.findAll().stream().forEach(championnat -> {
            PiloteDto winner = piloteRepository.winner(annee,championnat.getLibelleC());
            results.add(winner);
        });
        return results;
    }

    @Override
    @Scheduled(cron = "*/59 * * * * *")
    public void updateGeneralClassement() {
        LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), 1,1);
        LocalDate endDate = LocalDate.of(LocalDate.now().getYear(),12,31);

        piloteRepository.findAll().stream().forEach(pilote -> {
            pilote.getPositionPilotes().stream().forEach(position -> {
                Integer total = positionRepository
                        .findByCourseDateCourseBetweenAndCourseChampionnatsCategorieAndPiloteIdPilote(startDate, endDate, Categorie.FORMULA1,pilote.getIdPilote())
                        .stream()
                        .map(Position::getNbPoints).filter(Objects::nonNull)
                        .reduce(0, Integer::sum);

                pilote.setNbPointsTotal(total);
                piloteRepository.save(pilote);
            });


        });

        AtomicReference<Integer> position = new AtomicReference<>(1);
        piloteRepository.findByCategorie(Categorie.FORMULA1).stream().sorted(Comparator.comparingInt(Pilote::getNbPointsTotal)).forEach(pilote1 -> {
            pilote1.setClassementGeneral(position.get());
            position.set(position.get() + 1);
            piloteRepository.save(pilote1);
        });

    }

    @Override
    public HashMap<String, Float> top3Pilotes(String libelleC) {
        return null;
    }

    @Override
    public Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnnee(Long idEquipe, Long idChampionnat, String annee) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        Championnat championnat = championnatRepository.findById(idChampionnat).orElse(null);

        return piloteRepository.nbPointsParPilotesUneEquipeChampionnatCetteAnnee(equipe.getLibelleEq(),championnat.getLibelleC(),annee);
    }

    @Override
    public Pilote affecterPiloteAEquipe(String libelleP, String libelleEq) {
        Equipe equipe = equipeRepository.findByLibelleEq(libelleEq);
        Pilote pilote = piloteRepository.findByLibelleP(libelleP);
        pilote.setEquipe(equipe);
        piloteRepository.save(pilote);
        return pilote;
    }
}
