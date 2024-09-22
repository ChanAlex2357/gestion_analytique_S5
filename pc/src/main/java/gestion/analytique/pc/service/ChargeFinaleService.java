package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.ChargeFinale;
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

    public List<ChargeFinale> getAll() {
        return (List<ChargeFinale>) repository.findAll();
    }

    public Optional<ChargeFinale> getById(int id) {
        return repository.findById(id);
    }

    public ChargeFinale save(ChargeFinale chargeFinale) {
        return repository.save(chargeFinale);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
