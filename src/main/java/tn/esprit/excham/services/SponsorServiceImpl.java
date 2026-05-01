package tn.esprit.excham.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.excham.entities.Contrat;
import tn.esprit.excham.entities.Sponsor;
import tn.esprit.excham.repositories.ContratRepository;
import tn.esprit.excham.repositories.SponsorRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
@Slf4j
public class SponsorServiceImpl implements ISponsorService{

    SponsorRepository sponsorRepository;
    ContratRepository contratRepository;
    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        sponsor.setDateCreation(LocalDate.now());
        sponsor.setArchived(false);
        sponsor.setBloquerContrat(false);
        return sponsorRepository.save(sponsor);
    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        sponsors.forEach(sponsor -> {
            sponsor.setDateCreation(LocalDate.now());
            sponsor.setArchived(false);
            sponsor.setBloquerContrat(false);
        });
        return sponsorRepository.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        sponsor.setDateDerniereModification(LocalDate.now());
        return sponsorRepository.save(sponsor);
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {

         sponsorRepository.deleteById(idSponsor);
    }

    @Override
    public List<Sponsor> listSponsors() {

        return sponsorRepository.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {

        return sponsorRepository.findById(idSponsor).orElse(null);
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        Sponsor sponsor= sponsorRepository.findById(idSponsor).orElse(null);
        if (sponsor != null) {
            sponsor.setArchived(true);
            sponsorRepository.save(sponsor);
        }

        return true;
    }

    @Override
    public Float pourcentageBudgetAnnuelConsomme(Long idSponsor) {
        Sponsor sponsor= sponsorRepository.findById(idSponsor).orElse(null);
        List<Contrat> contrats = contratRepository.findBySponsorNomAndAnneeEquals( sponsor.getNom(), String.valueOf(LocalDate.now().getYear()));
        AtomicReference<Float> montantContrats = new AtomicReference<>((float) 0);
        contrats.forEach(contrat -> {
            montantContrats.updateAndGet(v -> v + contrat.getMontant());
        });
        return (montantContrats.get()/sponsor.getBudgetAnnuel())*100;
    }

    @Override
    @Scheduled(cron = "*/59 * * * * *")
    public void controlBudget() {
         log.info("controlBudget");
        sponsorRepository.findAll().forEach(sponsor -> {
    Float pourcentage = pourcentageBudgetAnnuelConsomme(sponsor.getIdSponsor());
            log.info("sponsor: "+ sponsor.getNom()+ " pourcentage : "+pourcentage);
            if(pourcentage>70 && pourcentage <100) {
                log.info("attention budget presque consommé : "+ pourcentage+ " % !");
            }
            else if (pourcentage>100){
                log.info("budget dépassé!! vous ne pouvez plus faire de contrats");
                sponsor.setBloquerContrat(true);
                sponsorRepository.save(sponsor);
            }

        });

    }
}
