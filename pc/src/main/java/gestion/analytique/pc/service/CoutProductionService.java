package gestion.analytique.pc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.analytique.pc.model.CentreProduction;
import gestion.analytique.pc.model.CentreProductionMere;
import gestion.analytique.pc.model.CoutCentre;
import gestion.analytique.pc.model.CoutProduction;
import gestion.analytique.pc.model.Exercice;
import gestion.analytique.pc.model.ProductionMere;
import lombok.Data;

@Service
@Data
public class CoutProductionService {
    @Autowired
    private CoutCentreService coutCentreService;
    @Autowired
    private ProductionService productionService;
    private CentreProductionService centreProductionService;
    private Exercice exercice;

    public CoutProductionService (){
        setExercice(null);
    ;
    }
    public List<CoutProduction> getCoutProduction() {
    // Step 1: Fetch all productions
    List<ProductionMere> productionMere = getProductionService().getProductionMere(exercice);

    // Step 2: Fetch the map of coutCentres by TypeCentre for the given exercice
    List<CoutCentre> coutCentresMap = getCoutCentreService().getAllCoutCentres(getExercice()).getAllCoutCentres();

    // Step 3: Fetch CentreProductionMere which holds the mapping between Produit and CentreProductions
    CentreProductionMere centreProductionMere = getCentreProductionService().getCentreProductionMere();

    // Step 4: Initialize the list to store CoutProduction objects
    List<CoutProduction> coutProductionList = new ArrayList<>();

    // Step 5: Iterate over each production
    for (ProductionMere productionM : productionMere) {
        
        // Get the associated list of CentreProductions for this production's product
        List<CentreProduction> centreProductions = centreProductionMere.getCentreProduit().get(productionM.getProduit());

        // Initialize the list to store the matching CoutCentre for this production
        List<CoutCentre> matchingCoutCentres = new ArrayList<>();

        // Sum to calculate the total cost for this production
        double sommeProductionCentre = 0.0;
        // Step 6: Iterate over each CentreProduction and find the corresponding CoutCentre
        if (centreProductions != null) {
            for (CentreProduction centreProduction : centreProductions) {
                CoutCentre coutCentre = getCoutCentreService().getCoutCentreByCentre(centreProduction.getCentre(), coutCentresMap);
                if (coutCentre != null) {
                    // Add the CoutCentre to the list for this CoutProduction
                    matchingCoutCentres.add(coutCentre);
                    // Accumulate the cost for sommeProductionCentre
                    sommeProductionCentre += coutCentre.getCoutTotal();
                }
            }
        }
        // Step 7: Calculate the cost of production (costDeRevient) if needed
        double coutDeRevient = sommeProductionCentre / productionM.getTotalProduction() ; // You can adjust this calculation based on your logic
        // Step 8: Create and build the CoutProduction object
        CoutProduction coutProduction = CoutProduction.builder()
                .production(productionM)
                .build();
        coutProduction.setCoutCentres(matchingCoutCentres);
        coutProduction.setSommeProductionCentre(sommeProductionCentre);
        coutProduction.setCoutDeRevient(coutDeRevient);

        // Step 9: Add the CoutProduction object to the result list
        coutProductionList.add(coutProduction);
    }

    // Step 10: Return the list of CoutProduction
    return coutProductionList;
}

}
