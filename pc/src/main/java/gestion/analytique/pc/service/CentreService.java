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

    // Get all centres
    public List<Centre> getAll() {
        return (List<Centre>) repository.findAll();
    }

    // Get a centre by ID
    public Optional<Centre> getById(int id) {
        return repository.findById(id);
    }

    // Save a new or updated centre
    public Centre save(Centre centre) {
        return repository.save(centre);
    }

    // Update an existing centre
    public Centre update(int id, Centre centre) {
        Optional<Centre> existingCentreOpt = repository.findById(id);
        if (existingCentreOpt.isPresent()) {
            Centre existingCentre = existingCentreOpt.get();
            // Update the fields of the existing centre
            existingCentre.setName(centre.getName());
            // Add more fields if needed
            return repository.save(existingCentre);
        } else {
            return null; // Or throw an exception if needed
        }
    }

    // Delete a centre by ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
