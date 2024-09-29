package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.TypeCharge;
import gestion.analytique.pc.repository.TypeChargeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TypeChargeService {

    private final TypeChargeRepository repository;

    @Autowired
    public TypeChargeService(TypeChargeRepository repository) {
        this.repository = repository;
    }

    public List<TypeCharge> getAll() {
        return (List<TypeCharge>) repository.findAll();
    }

    public Optional<TypeCharge> getById(int id) {
        return repository.findById(id);
    }

    public TypeCharge save(TypeCharge unit) {
        return repository.save(unit);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
