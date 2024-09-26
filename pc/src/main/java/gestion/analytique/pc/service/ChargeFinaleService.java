package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.Charge;
import gestion.analytique.pc.repository.ChargeFinaleRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ChargeFinaleService {
    private final ChargeFinaleRepository repository;

    @Autowired
    public ChargeFinaleService(ChargeFinaleRepository repository) {
        this.repository = repository;
    }

    public List<Charge> getAll() {
        return (List<Charge>) repository.findAll();
    }

    public Optional<Charge> getById(int id) {
        return repository.findById(id);
    }

    public Charge save(Charge chargeFinale) {
        return repository.save(chargeFinale);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
