package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import gestion.analytique.pc.model.Exercice;
import gestion.analytique.pc.model.Production;
import gestion.analytique.pc.repository.ProductionRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductionService {
    private final ProductionRepository repository;

    @Autowired
    public ProductionService(ProductionRepository repository) {
        this.repository = repository;
    }

    public List<Production> getAll() {
        return (List<Production>) repository.findAll();
    }

    public Optional<Production> getById(int id) {
        return repository.findById(id);
    }

    public Production save(Production production) {
        return repository.save(production);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Production> getProductions( Exercice exercice ){
        return repository.findProductionByExercice(exercice.getDate_debut(),exercice.getDate_fin());
    }
}
