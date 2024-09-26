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

    public double getSommeOperationnelle() {
        if (sommeOperationnelle != 0.0) {
            return sommeOperationnelle;
        }    
        sommeOperationnelle = coutCentres.entrySet().stream()
            .filter(entry -> entry.getKey().getName().equalsIgnoreCase("Opérationnelle"))
            .flatMap(entry -> entry.getValue().stream()) 
            .mapToDouble(CoutCentre::getCoutDirectTotal)
            .sum();
    
        return sommeOperationnelle;
    }

    public double getSommeStructurelle() {
        if (sommeStructurelle != 0.0) {
            return sommeStructurelle;
        }
        sommeStructurelle = coutCentres.entrySet().stream()
            .filter(entry -> entry.getKey().getName().equalsIgnoreCase("Structurelle"))
            .flatMap(entry -> entry.getValue().stream()) 
            .mapToDouble(CoutCentre::getCoutDirectTotal)
            .sum();
    
        return sommeStructurelle;
    }

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