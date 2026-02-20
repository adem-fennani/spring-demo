package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repository.SponsorRepository;
import tn.esprit.entities.Sponsor;

import java.util.List;

@Service
public class SponsorService implements ISponsorService{

    @Autowired
    SponsorRepository sp;

    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        return sp.save(sponsor);
    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        return sp.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        return sp.save(sponsor);
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {
         sp.deleteById(idSponsor);
    }

    @Override
    public List<Sponsor> listSponsors() {
        return sp.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
       return  sp.findById(idSponsor).orElse(null);
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        Sponsor sponsor = sp.findById(idSponsor).orElse(null);
        sponsor.setArchived(Boolean.TRUE);
         sp.save(sponsor);
         return sponsor.getArchived();
    }
}
