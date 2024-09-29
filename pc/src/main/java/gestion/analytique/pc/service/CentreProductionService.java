package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import gestion.analytique.pc.model.Centre;
import gestion.analytique.pc.model.CentreProduction;
import gestion.analytique.pc.model.CentreProduction;
import gestion.analytique.pc.model.Produit;
import gestion.analytique.pc.repository.CentreProductionRepository;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CentreProductionService {
    private final CentreProductionRepository repository;
    private List<CentreProduction> centreProductions;
    @Autowired
    public CentreProductionService(CentreProductionRepository repository) {
        this.repository = repository;
    }
    public List<Centre> getCentresByProduit(Produit produit) {
        return repository.findCentresByProduit(produit);
    }
    public List<CentreProduction> getAll() {
        return (List<CentreProduction>) repository.findAll();
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
