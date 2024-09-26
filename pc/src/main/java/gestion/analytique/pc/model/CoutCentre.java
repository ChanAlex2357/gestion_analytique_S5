package gestion.analytique.pc.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class CoutCentre {
    private Centre centre;
    private Map<Nature, Double> natureMontant;
    private Exercice exercice;
    private Double coutTotal;
    private Double coutDirectTotal;

    // Constructor
    @Builder
    public CoutCentre(Centre centre, Exercice exercice, Map<Nature, Double> montantTotalParNature) {
        this.centre = centre;
        this.exercice = exercice;
        this.natureMontant = montantTotalParNature;
        setCoutDirectTotal();
    }

    public void setCoutDirectTotal() {
        this.coutDirectTotal = natureMontant.values().stream()
            .mapToDouble(Double::doubleValue)
            .sum();
    }
}