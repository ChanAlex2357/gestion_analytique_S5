package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import gestion.analytique.pc.model.Exercice;
import gestion.analytique.pc.model.Production;
import gestion.analytique.pc.model.ProductionMere;
import gestion.analytique.pc.model.Produit;
import gestion.analytique.pc.repository.ProductionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductionService {
    private final ProductionRepository repository;

    @Autowired
    public ProductionService(ProductionRepository repository) {
        this.repository = repository;
    }

    public List<Production> getAll() {
        return (List<Production>) repository.findAll();
    }

    public Optional<Production> getById(int id) {
        return repository.findById(id);
    }

    public Production save(Production production) {
        return repository.save(production);
    }

    public Production update(int id, Production updatedProduction) {
        Optional<Production> existingProductionOpt = getById(id);

        if (existingProductionOpt.isPresent()) {
            Production existingProduction = existingProductionOpt.get();
            // Mettre à jour les champs nécessaires
            existingProduction.setQuantite(updatedProduction.getQuantite());
            existingProduction.setDate_production(updatedProduction.getDate_production());
            existingProduction.setProduit(updatedProduction.getProduit());
            // Mettez à jour d'autres champs si nécessaire

            return repository.save(existingProduction); // Sauvegarder la mise à jour
        } else {
            // Vous pouvez choisir de gérer l'absence de l'élément avec une exception ou un retour spécifique
            return null;
        }
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Production> getAllByExercice(Exercice exercice) {
        // return repository.findAllByExercice(exercice.getDate_debut(), exercice.getDate_fin());
        return getAll();
    }

    public List<ProductionMere> getProductionMere(Exercice exercice) {
        // Step 1: Retrieve all production records
        List<Production> allProductions = getAllByExercice(exercice);

        // Step 2: Initialize a map to group productions by Produit
        HashMap<Produit, List<Production>> productionMap = new HashMap<>();

        // Step 3: Iterate through the list of productions
        for (Production production : allProductions) {
            Produit produit = production.getProduit(); // Assuming Production has a getProduit() method

            // Step 4: Group productions by Produit
            productionMap.computeIfAbsent(produit, k -> new ArrayList<>()).add(production);
        }

        // Step 5: Create a list of ProductionMere objects
        List<ProductionMere> productionMereList = new ArrayList<>();

        // Step 6: Iterate over the map entries and create ProductionMere objects
        for (Map.Entry<Produit, List<Production>> entry : productionMap.entrySet()) {
            Produit produit = entry.getKey();
            List<Production> productionsForProduit = entry.getValue();

            // Calculate the total production for this Produit
            double totalProduction = productionsForProduit.stream()
                    .mapToDouble(Production::getQuantite) // Assuming Production has a getQuantite() method
                    .sum();

            // Step 7: Create a new ProductionMere object
            ProductionMere productionMere = new ProductionMere();
            productionMere.setExercice(exercice);
            productionMere.setProduit(produit);
            productionMere.setProductions(productionsForProduit);
            productionMere.setTotalProduction(totalProduction);

            // Add the ProductionMere object to the list
            productionMereList.add(productionMere);
        }

        // Step 8: Return the list of ProductionMere objects
        return productionMereList;
    }
}
