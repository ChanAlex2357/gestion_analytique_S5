package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import gestion.analytique.pc.model.CoutCentre;
import gestion.analytique.pc.repository.CoutCentreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CoutCentreService {
    private final CoutCentreRepository repository;

    @Autowired
    public CoutCentreService(CoutCentreRepository repository) {
        this.repository = repository;
    }

    public List<CoutCentre> getAll() {
        return (List<CoutCentre>) repository.findAll();
    }

    public Optional<CoutCentre> getById(int id) {
        return repository.findById(id);
    }

    public CoutCentre save(CoutCentre coutCentre) {
        return repository.save(coutCentre);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
