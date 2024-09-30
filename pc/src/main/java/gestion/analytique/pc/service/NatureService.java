package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.Nature;
import gestion.analytique.pc.repository.NatureRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NatureService {

    private final NatureRepository repository;

    @Autowired
    public NatureService(NatureRepository repository) {
        this.repository = repository;
    }

    public List<Nature> getAll() {
        return (List<Nature>) repository.findAll();
    }

    public Optional<Nature> getById(int id) {
        return repository.findById(id);
    }

    public Nature save(Nature nature) {
        return repository.save(nature);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    // Ajout de la fonction update
    public Nature update(int id, Nature nature) {
        // Vérification si l'objet existe déjà
        Optional<Nature> existingNatureOpt = repository.findById(id);
        if (existingNatureOpt.isPresent()) {
            Nature existingNature = existingNatureOpt.get();
            // Mise à jour des champs nécessaires
            existingNature.setName(nature.getName()); // Mise à jour des champs appropriés
            // Enregistrement de l'objet mis à jour dans le dépôt
            return repository.save(existingNature);
        } else {
            return null; // Si l'objet avec cet ID n'existe pas
        }
    }
}
