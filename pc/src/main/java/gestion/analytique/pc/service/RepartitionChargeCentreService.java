package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.RepartitionChargeCentre;
import gestion.analytique.pc.repository.RepartitionChargeCentreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RepartitionChargeCentreService {

    private final RepartitionChargeCentreRepository repository;

    @Autowired
    public RepartitionChargeCentreService(RepartitionChargeCentreRepository repository) {
        this.repository = repository;
    }

    public List<RepartitionChargeCentre> getAll() {
        return (List<RepartitionChargeCentre>) repository.findAll();
    }

    public Optional<RepartitionChargeCentre> getById(int id) {
        return repository.findById(id);
    }

    public RepartitionChargeCentre save(RepartitionChargeCentre repartitionChargeCentre) {
        return repository.save(repartitionChargeCentre);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
