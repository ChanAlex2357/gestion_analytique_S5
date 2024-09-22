package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.TypeCentre;
import gestion.analytique.pc.repository.TypeCentreRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TypeCentreService {
    private final TypeCentreRepository repository;

    @Autowired
    public TypeCentreService(TypeCentreRepository repository) {
        this.repository = repository;
    }

    public List<TypeCentre> getAll() {
        return (List<TypeCentre>) repository.findAll();
    }

    public Optional<TypeCentre> getById(int id) {
        return repository.findById(id);
    }

    public TypeCentre save(TypeCentre typeCentre) {
        return repository.save(typeCentre);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
