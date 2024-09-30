package gestion.analytique.pc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.analytique.pc.model.AdminCoutCentre;
import gestion.analytique.pc.model.Centre;
import gestion.analytique.pc.model.CoutCentre;
import gestion.analytique.pc.model.Exercice;
import gestion.analytique.pc.model.TypeCentre;
import gestion.analytique.pc.model.ViewCoutCentre;
import gestion.analytique.pc.model.ViewCoutCentreId;
import gestion.analytique.pc.repository.CoutCentreRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CoutCentreService {
    private final CoutCentreRepository repository;
    
    @Autowired
    public CoutCentreService(CoutCentreRepository repository) {
        this.repository = repository;
    }

    public HashMap<TypeCentre, List<CoutCentre>> getCoutCentres(Exercice exercice){
        List<ViewCoutCentre> viewCoutCentres = getAllByExercice(exercice);
        return getCoutCentres(viewCoutCentres, exercice);
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
    public AdminCoutCentre getAllCoutCentres(AdminCoutCentre adminCoutCentre,Exercice exercice){
        HashMap<TypeCentre, List<CoutCentre>> coutCentresMap = getCoutCentres(exercice);
        // Step 2: Initialize an empty list to store all CoutCentre objects
        List<CoutCentre> allCoutCentres = new ArrayList<>();

        // Step 3: Iterate over each entry in the map and combine the lists
        for (List<CoutCentre> coutCentres : coutCentresMap.values()) {
            // Add all elements from each list to the combined list
            allCoutCentres.addAll(coutCentres);
        }

        // Step 4: Return the combined list of all CoutCentre
        if (adminCoutCentre == null) {
            adminCoutCentre = AdminCoutCentre.builder()
            .exercice(exercice)
            .allCoutCentres(allCoutCentres)
            .coutCentres(coutCentresMap)
            .build();
        }
        else {
            adminCoutCentre.setExercice(exercice);
            adminCoutCentre.setAllCoutCentres(allCoutCentres);
            adminCoutCentre.setCoutCentres(coutCentresMap);
        }
        
        return adminCoutCentre;
    }
    public AdminCoutCentre getAllCoutCentres(Exercice exercice){
        return getAllCoutCentres(null, exercice);
    }
    public CoutCentre getCoutCentreByCentre(Centre centre, List<CoutCentre> allCoutCentres) {
        
        // Step 2: Iterate through the list and find the matching CoutCentre for the given Centre
        for (CoutCentre coutCentre : allCoutCentres) {
            if (coutCentre.getCentre().equals(centre)) {
                // Step 3: Return the matching CoutCentre
                return coutCentre;
            }
        }
    
        // Step 4: If no matching CoutCentre is found, return null or throw an exception
        return null;
    }
    public CoutCentre getCoutCentreByCentre(Centre centre, Exercice exercice) {
        // Step 1: Get the combined list of all CoutCentre objects for the given exercice
        List<CoutCentre> allCoutCentres = getAllCoutCentres(exercice).getAllCoutCentres();
        return getCoutCentreByCentre(centre, allCoutCentres);
    }
    
    private void setCoutTotal(CoutCentre coutCentre) {
        // WHY VIDE
    }

    public List<ViewCoutCentre> getAllByExercice(Exercice exercice) {
        // return repository.findAllByExercice(exercice.getDate_debut(), exercice.getDate_fin());
        return getAll();
    }

    public List<ViewCoutCentre> getAll() {
        return (List<ViewCoutCentre>) repository.findAll();
    }

    public Optional<ViewCoutCentre> getById(ViewCoutCentreId id) {
        return repository.findById(id);
    }

    public ViewCoutCentre save(ViewCoutCentre coutCentre) {
        return repository.save(coutCentre);
    }

    public void delete(ViewCoutCentreId id) {
        repository.deleteById(id);
    }
}
