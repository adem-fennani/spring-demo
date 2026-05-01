package tn.esprit.excham.services;

import tn.esprit.excham.entities.Sponsor;
import tn.esprit.excham.repositories.SponsorRepository;

import java.util.List;

public class SponsorServiceImpl2 implements ISponsorService{
    private SponsorRepository sponsorRepository;

    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);


    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        return List.of();
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        return null;
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {

    }

    @Override
    public List<Sponsor> listSponsors() {
        return List.of();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
        return null;
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        return null;
    }

    @Override
    public Float pourcentageBudgetAnnuelConsomme(Long idSponsor) {
        return 0f;
    }

    @Override
    public void controlBudget() {

    }
}
