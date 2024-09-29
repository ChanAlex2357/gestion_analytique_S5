package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.Produit;
import gestion.analytique.pc.repository.ProduitRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    private final ProduitRepository repository;

    @Autowired
    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    public List<Produit> getAll() {
        return (List<Produit>) repository.findAll();
    }

    public Optional<Produit> getById(int id) {
        return repository.findById(id);
    }

    public Produit save(Produit produit) {
        return repository.save(produit);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
