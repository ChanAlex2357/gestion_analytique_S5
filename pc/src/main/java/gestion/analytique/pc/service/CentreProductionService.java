package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.CentreProductionId;
import gestion.analytique.pc.repository.CentreProductionRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CentreProductionService {
    private final CentreProductionRepository repository;

    @Autowired
    public CentreProductionService(CentreProductionRepository repository) {
        this.repository = repository;
    }

    public List<CentreProductionId> getAll() {
        return (List<CentreProductionId>) repository.findAll();
    }

    public Optional<CentreProductionId> getById(int id) {
        return repository.findById(id);
    }

    public CentreProductionId save(CentreProductionId centreProductionId) {
        return repository.save(centreProductionId);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
