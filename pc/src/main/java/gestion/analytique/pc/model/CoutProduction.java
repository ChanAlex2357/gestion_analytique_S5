package gestion.analytique.pc.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoutProduction {
    private ProductionMere          production;
    private List<CoutCentre>    coutCentres;
    private Double              sommeProductionCentre;
    private Double              coutDeRevient;

    @Builder
    public CoutProduction(ProductionMere production){
        setProduction(production);
    }
}
