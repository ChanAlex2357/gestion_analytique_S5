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

    @Builder
    public CoutCentre(Centre centre, Exercice exercice) {
        this.centre = centre;
        this.exercice = exercice;
        this.natureMontant = new HashMap<>();
    }

    public void setCoutDirectTotal() {
        this.coutDirectTotal = natureMontant.values().stream()
            .mapToDouble(Double::doubleValue)
            .sum();
    }
}