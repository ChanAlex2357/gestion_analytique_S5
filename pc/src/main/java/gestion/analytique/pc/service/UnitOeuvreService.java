package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.UnitOeuvre;
import gestion.analytique.pc.repository.UnitOeuvreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UnitOeuvreService {

    private final UnitOeuvreRepository repository;

    @Autowired
    public UnitOeuvreService(UnitOeuvreRepository repository) {
        this.repository = repository;
    }

    public List<UnitOeuvre> getAll() {
        return (List<UnitOeuvre>) repository.findAll();
    }

    public Optional<UnitOeuvre> getById(int id) {
        return repository.findById(id);
    }

    public UnitOeuvre save(UnitOeuvre unit) {
        return repository.save(unit);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
