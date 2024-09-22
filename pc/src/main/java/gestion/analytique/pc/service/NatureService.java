package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.Nature;
import gestion.analytique.pc.repository.NatureRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NatureService {

    private final NatureRepository repository;

    @Autowired
    public NatureService(NatureRepository repository) {
        this.repository = repository;
    }

    public List<Nature> getAll() {
        return (List<Nature>) repository.findAll();
    }

    public Optional<Nature> getById(int id) {
        return repository.findById(id);
    }

    public Nature save(Nature unit) {
        return repository.save(unit);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
