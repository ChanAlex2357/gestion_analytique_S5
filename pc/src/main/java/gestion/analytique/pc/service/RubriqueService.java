package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import gestion.analytique.pc.model.Rubrique;
import gestion.analytique.pc.repository.RubriqueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RubriqueService {
    private final RubriqueRepository repository;

    @Autowired
    public RubriqueService(RubriqueRepository repository) {
        this.repository = repository;
    }

    public List<Rubrique> getAll() {
        return (List<Rubrique>) repository.findAll();
    }

    public Optional<Rubrique> getById(int id) {
        return repository.findById(id);
    }

    public Rubrique save(Rubrique unit) {
        return repository.save(unit);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
