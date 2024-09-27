package gestion.analytique.pc.model;

import java.util.HashMap;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AdminCoutCentre {
    private Exercice exercice;
    private HashMap<TypeCentre, List<CoutCentre>> coutCentres;
    private double sommeOperationnelle;
    private double sommeStructurelle;
    private double sommeCoutTotal;

    // Constructor
    @Builder
    public AdminCoutCentre(Exercice exercice, HashMap<TypeCentre, List<CoutCentre>> coutCentres) {
        this.exercice = exercice;
        this.coutCentres = coutCentres;
        this.sommeOperationnelle = 0.0;
        this.sommeStructurelle = 0.0;
        this.sommeCoutTotal = 0.0;
    }
}