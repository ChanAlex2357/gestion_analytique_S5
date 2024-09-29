package gestion.analytique.pc.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoutProduction {
    private Production          production;
    private List<Centre>        centreProduction;
    private Double              sommeProductionCentre;
    private Double              coutDeRevient;

    @Builder
    public CoutProduction(Production production){
        setProduction(production);
    }
}
