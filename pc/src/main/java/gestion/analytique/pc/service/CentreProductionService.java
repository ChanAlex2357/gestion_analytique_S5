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

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class CentreProductionService {
    private final CentreProductionRepository repository;
    @Autowired
    public CentreProductionService(CentreProductionRepository repository) {
        this.repository = repository;
    }
    public List<CentreProduction> getAll() {
        return (List<CentreProduction>) repository.findAll();
    }
    public CentreProductionMere instantiateCentreProductionMere() {
        List<CentreProduction> centreProductions = getAll();

        // Initialize the HashMap
        HashMap<Produit, CentreProduction> centreProduitMap = new HashMap<>();

        // Populate the HashMap from the List<CentreProduction>
        for (CentreProduction cp : centreProductions) {
            centreProduitMap.put(cp.getProduit() , cp);
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
