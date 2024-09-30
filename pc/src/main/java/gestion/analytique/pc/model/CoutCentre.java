package gestion.analytique.pc.model;
import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class CoutCentre {
    private Centre centre;
    private HashMap<Nature, Double> natureMontant;
    private Exercice exercice;
    private Double coutTotal;
    private Double coutDirectTotal;
    private Double cles;

    @Builder
    public CoutCentre(Centre centre, Exercice exercice) {
        this.centre = centre;
        this.exercice = exercice;
        this.coutTotal = 0.0;
        this.natureMontant = new HashMap<>();
        this.cles = 0.0;
    }

    public void setCoutDirectTotal() {
        this.coutDirectTotal = natureMontant.values().stream()
            .mapToDouble(Double::doubleValue)
            .sum();
    }
}