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

    public TypeCharge save(TypeCharge typeCharge) {
        return repository.save(typeCharge);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public TypeCharge update(int id, TypeCharge updatedTypeCharge) {
        // Vérifier si l'élément existe
        Optional<TypeCharge> existingTypeCharge = repository.findById(id);
        if (existingTypeCharge.isPresent()) {
            TypeCharge typeCharge = existingTypeCharge.get();
            // Mettez à jour les champs nécessaires ici
            typeCharge.setName(updatedTypeCharge.getName()); // Exemple de mise à jour
            // Ajoutez d'autres mises à jour de champs si nécessaire

            return repository.save(typeCharge); // Enregistrez et renvoyez l'élément mis à jour
        }
        return null; // Retourne null si l'élément n'existe pas
    }
}
