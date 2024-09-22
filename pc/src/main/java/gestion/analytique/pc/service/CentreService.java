package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.Centre;
import gestion.analytique.pc.repository.CentreRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CentreService {
    private final CentreRepository repository;

    @Autowired
    public CentreService(CentreRepository repository) {
        this.repository = repository;
    }

    public List<Centre> getAll() {
        return (List<Centre>) repository.findAll();
    }

    public Optional<Centre> getById(int id) {
        return repository.findById(id);
    }

    public Centre save(Centre centre) {
        return repository.save(centre);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
