package gestion.analytique.pc.model;

import java.util.HashMap;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoutProduction {
    private Production      production;
    private Exercice        exercice;
    private CoutCentre[]    coutCentres;
    private Double          sommeProductionCentre;
    private Double          coutDeRevient;

    @Builder
    public CoutProduction(Production production){
        setProduction(production);
    }
}
