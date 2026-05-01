package tn.esprit.excham.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.excham.entities.*;
import tn.esprit.excham.mapper.ContratMapper;
import tn.esprit.excham.repositories.ContratRepository;
import tn.esprit.excham.repositories.EquipeRepository;
import tn.esprit.excham.repositories.SponsorRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j

public class ContratServiceImpl implements IContratService{
    ContratRepository contratRepository;
    SponsorRepository sponsorRepository;
    EquipeRepository equipeRepository;
    ContratMapper contratMapper;
    @Override
    public Contrat ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, String libelleEquipe, String nomSponsor, String pays) {
        Equipe equipe = equipeRepository.findByLibelleEq(libelleEquipe);
        Sponsor sponsor= sponsorRepository.findByNomAndPays(nomSponsor,pays);
        contrat.setEquipe(equipe);
        contrat.setSponsor(sponsor);
        contrat.setArchived(false);
        return contratRepository.save(contrat);
    }
    @Scheduled(cron = "*/59 * * * * *")
    @Override
    public void archiverContratsExpireesEtAffichageContratsActifsParEquipe() {
       List <Contrat> contratsNonArchives = contratRepository.findByArchived(false);
       contratsNonArchives.forEach(contrat -> {
           if (Integer.parseInt(contrat.getAnnee())< LocalDate.now().getYear()){
               contrat.setArchived(true);
               contratRepository.save(contrat);
           }
       });

       equipeRepository.findAll().forEach(equipe -> {
           if(equipe.getContrats()!=null) {
             equipe.getContrats().forEach(contrat -> {
                 if(!contrat.getArchived()) {
                     log.info("L'équipe " + equipe.getLibelleEq() + " a un contrat d'un montant de " +
                             " " + contrat.getMontant()+ " avec le sponsor "+contrat.getSponsor().getNom());
                 }
             });
           }
       });

    }

    @Override
    public HashMap<String, Float> historiqueContratsEquipe(String libelleEquipe) {
        HashMap<String, Float> historiqueContrats = new HashMap<>();
        Equipe equipe = equipeRepository.findByLibelleEq(libelleEquipe);
        List<Contrat> contrats = contratRepository.findByEquipeLibelleEq(libelleEquipe);
        contrats.forEach(contrat -> {
            historiqueContrats.put(equipe.getLibelleEq(),contrat.getMontant());
        });

        return historiqueContrats;
    }

    public ContratResponseDTO  ajoutContratEtAffecterASponsorEtEquipe(
            ContratRequestDTO dto, String libelleEquipe, String nomSponsor, String pays) {

        Equipe equipe = equipeRepository.findByLibelleEq(libelleEquipe);
        Sponsor sponsor = sponsorRepository.findByNomAndPays(nomSponsor, pays);
        Contrat contrat = Contrat.builder().montant(dto.getMontant()).annee(dto.getAnnee())
                .archived(false).equipe(equipe).sponsor(sponsor).build();
        Contrat savedContrat = contratRepository.save(contrat);
        return new ContratResponseDTO(
                savedContrat.getIdContrat(),
                savedContrat.getMontant(),
                savedContrat.getAnnee(),
                equipe.getLibelleEq(),
                sponsor.getNom()
        );
    }

    public ContratResponseDTO ajoutContratEtAffecterASponsorEtEquipeMapper(
            ContratRequestDTO dto, String libelleEquipe, String nomSponsor, String pays) {

        Equipe equipe = equipeRepository.findByLibelleEq(libelleEquipe);
        Sponsor sponsor = sponsorRepository.findByNomAndPays(nomSponsor, pays);
        Contrat contrat = contratMapper.toEntity(dto);

        contrat.setEquipe(equipe);
        contrat.setSponsor(sponsor);
        contrat.setArchived(false);

        Contrat saved = contratRepository.save(contrat);
        return contratMapper.toDTO(saved);
    }

}
