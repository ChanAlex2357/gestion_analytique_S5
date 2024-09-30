package gestion.analytique.pc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoutProduction {
    private ProductionMere      production;
    private List<CoutCentre>    coutCentres;
    private HashMap<String,Double> montantByNature;
    private Double              sommeProductionCentre;
    private Double              coutDeRevient;

    @Builder
    public CoutProduction(ProductionMere production){
        setProduction(production);
    }
    public void setMontantByNature(){
        setMontantByNature( calculateTotalMontantsByNature());
    }
    // Method to calculate the sum of amounts for each Nature
    public HashMap<String, Double> calculateTotalMontantsByNature() {
        HashMap<String,Double> totalMontantsByNature = new HashMap<>();

        // Iterate through each CoutCentre
        for (CoutCentre coutCentre : coutCentres) {
            HashMap<Nature, Double> natureMontants = coutCentre.getNatureMontant(); // Assuming you have a getter for this

            // Iterate through each nature and amount in the current CoutCentre
            for (Map.Entry<Nature, Double> entry : natureMontants.entrySet()) {
                Nature nature = entry.getKey();
                Double montant = entry.getValue();

                // Add to the total for the respective Nature
                totalMontantsByNature.put(nature.getName(), totalMontantsByNature.getOrDefault(nature.getName(), 0.0) + montant);
            }
        }

        return totalMontantsByNature;
    }
}
