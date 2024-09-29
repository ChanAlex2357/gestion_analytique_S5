package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import gestion.analytique.pc.model.Centre;
import gestion.analytique.pc.model.CentreProduction;
import gestion.analytique.pc.model.CentreProductionMere;
import gestion.analytique.pc.model.CentreProduction;
import gestion.analytique.pc.model.Produit;
import gestion.analytique.pc.repository.CentreProductionRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class CentreProductionService {
    @Autowired
    private final CentreProductionRepository repository;
    
    public List<CentreProduction> getAll() {
        return (List<CentreProduction>) repository.findAll();
    }
    public CentreProductionMere getCentreProductionMere() {
        List<CentreProduction> centreProductions = getAll();

        // Initialize the HashMap
        HashMap<Produit, List<CentreProduction>> centreProduitMap = new HashMap<>();

        // Populate the HashMap from the List<CentreProduction>
        for (CentreProduction cp : centreProductions) {
        Produit produit = cp.getProduit(); // Extract the Produit from the CentreProduction

        // Step 4: Add the CentreProduction to the corresponding list in the HashMap
        centreProduitMap
            .computeIfAbsent(produit, k -> new ArrayList<>()) // If no list exists for this Produit, create a new one
            .add(cp); // Add the current CentreProduction to the list
    }
        // Create a new CentreProductionMere object and set the map
        CentreProductionMere centreProductionMere = new CentreProductionMere();
        centreProductionMere.setCentreProduit(centreProduitMap);

        return centreProductionMere;
    }

    public Optional<CentreProduction> getById(int id) {
        return repository.findById(id);
    }

    public CentreProduction save(CentreProduction centreProduction) {
        return repository.save(centreProduction);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
