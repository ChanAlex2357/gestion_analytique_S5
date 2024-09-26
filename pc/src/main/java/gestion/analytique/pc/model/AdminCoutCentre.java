package gestion.analytique.pc.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AdminCoutCentre {
    private Exercice exercice;
    private List<CoutCentre> coutCentres;
    private double sommeOperationnelle;
    private double sommeStructurelle;
    private double sommeCoutTotal;

    // Constructor
    @Builder
    public AdminCoutCentre(Exercice exercice) {
        this.exercice = exercice;
        this.coutCentres = new ArrayList<>();
        this.sommeOperationnelle = 0.0;
        this.sommeStructurelle = 0.0;
        this.sommeCoutTotal = 0.0;
    }
}