package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.DetailCharge;
import gestion.analytique.pc.repository.DetailChargeRepository;
import gestion.analytique.pc.repository.ChargeFinaleRepository;
import gestion.analytique.pc.repository.CoutCentreRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DetailChargeService {
    private final DetailChargeRepository repository;
    private ChargeFinaleRepository chargeFinaleRepository;
    private CoutCentreRepository CoutCentreRepository;


    @Autowired
    public DetailChargeService(DetailChargeRepository repository) {
        this.repository = repository;
    }

    public List<DetailCharge> getAll() {
        return (List<DetailCharge>) repository.findAll();
    }

    public Optional<DetailCharge> getById(int id) {
        return repository.findById(id);
    }

    public DetailCharge save(DetailCharge detailCharge) {
        return repository.save(detailCharge);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
