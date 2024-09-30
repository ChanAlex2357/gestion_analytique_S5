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

    // Méthode pour mettre à jour un TypeCentre existant
    public TypeCentre update(int id, TypeCentre typeCentre) {
        // Vérifier si l'entité existe
        Optional<TypeCentre> existingTypeCentreOpt = repository.findById(id);
        if (existingTypeCentreOpt.isPresent()) {
            TypeCentre existingTypeCentre = existingTypeCentreOpt.get();
            // Mettre à jour les champs nécessaires
            existingTypeCentre.setName(typeCentre.getName());  // Mettez à jour le nom (ajustez selon vos attributs)
            // existingTypeCentre.setDescription(typeCentre.getDescription());  // Mettez à jour la description (ajustez selon vos attributs)
            // Enregistrer l'entité mise à jour
            return repository.save(existingTypeCentre);
        } else {
            return null; // Retourner null si l'entité n'existe pas
        }
    }
}
