package tn.esprit.excham.services;

import tn.esprit.excham.entities.Sponsor;

import java.util.List;

public interface ISponsorService {
    Sponsor ajouterSponsor(Sponsor sponsor);
    List<Sponsor> ajouterSponsors(List<Sponsor> sponsors);
    Sponsor modifierSponsor(Sponsor sponsor);
    void supprimerSponsor (Long idSponsor);
    List<Sponsor> listSponsors();
    Sponsor recupererSponsor(Long idSponsor);
    Boolean archiverSponsor(Long idSponsor);
    Float pourcentageBudgetAnnuelConsomme(Long idSponsor);
     // en utilisant le service développé auparavant, écrire une fonction schédulé qui permet
    // d'afficher le msg attention a votre budget si le budget dépasse 80% et un msg budget dépassé sil le surpasse
    // en mettant le champs bloquernvContratAfalse
    void controlBudget();
}
