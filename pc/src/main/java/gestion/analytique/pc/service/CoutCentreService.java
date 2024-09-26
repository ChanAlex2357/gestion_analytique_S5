package gestion.analytique.pc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.analytique.pc.model.Centre;
import gestion.analytique.pc.model.CoutCentre;
import gestion.analytique.pc.model.Exercice;
import gestion.analytique.pc.model.Nature;
import gestion.analytique.pc.model.TypeCentre;
import gestion.analytique.pc.model.ViewCoutCentre;
import gestion.analytique.pc.repository.CoutCentreRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CoutCentreService {
    @Autowired
    private final CoutCentreRepository repository;

    public CoutCentreService(CoutCentreRepository repository) {
        this.repository = repository;
    }

    public HashMap<TypeCentre, List<CoutCentre>> getCoutCentres(List<ViewCoutCentre> viewCoutCentres, Exercice exercice) {
        HashMap<TypeCentre, List<CoutCentre>> coutCentresMap = new HashMap<>();
        HashMap<Centre, CoutCentre> centreCoutCentreMap = new HashMap<>();
        for (ViewCoutCentre viewCoutCentre : viewCoutCentres) {
            Centre centre = viewCoutCentre.getCentre();
            TypeCentre typeCentre = centre.getTypeCentre();
            CoutCentre coutCentre = centreCoutCentreMap.get(centre);
            if (coutCentre == null) {
                coutCentre = CoutCentre.builder()
                    .centre(centre)
                    .exercice(exercice) 
                    .build();        
                centreCoutCentreMap.put(centre, coutCentre);        
                coutCentresMap.computeIfAbsent(typeCentre, k -> new ArrayList<>()).add(coutCentre);
            }        
            coutCentre.getNatureMontant().merge(viewCoutCentre.getNatureCharge(), viewCoutCentre.getMontant(), Double::sum);
            coutCentre.setCoutDirectTotal();
            setCoutTotal(coutCentre);
        }
        return coutCentresMap;
    }
    private void setCoutTotal(CoutCentre coutCentre) {
        
    }

    public List<ViewCoutCentre> getAllByExercice(Exercice exercice) {
        return repository.findAllByExercice(exercice.getDate_debut(), exercice.getDate_fin());
    }

    public List<ViewCoutCentre> getAll() {
        return (List<ViewCoutCentre>) repository.findAll();
    }

    public Optional<ViewCoutCentre> getById(int id) {
        return repository.findById(id);
    }

    public ViewCoutCentre save(ViewCoutCentre coutCentre) {
        return repository.save(coutCentre);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
