package gestion.analytique.pc.model;

import java.util.HashMap;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
public class AdminCoutCentre {
    private Exercice exercice;
    private List<CoutCentre> allCoutCentres;
    private HashMap<TypeCentre, List<CoutCentre>> coutCentres;
    private double sommeOperationnelle;
    private double sommeStructurelle;
    private double sommeCoutTotal;

    // Constructor
    @Builder
    public AdminCoutCentre(Exercice exercice, HashMap<TypeCentre, List<CoutCentre>> coutCentres , List<CoutCentre> allCoutCentres) {
        this.exercice = exercice;
        this.coutCentres = coutCentres;
        this.allCoutCentres = allCoutCentres;
        this.sommeOperationnelle = 0.0;
        this.sommeStructurelle = 0.0;
        this.sommeCoutTotal = 0.0;
    }
}