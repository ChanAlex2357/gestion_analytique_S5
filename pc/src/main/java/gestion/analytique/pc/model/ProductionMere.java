package gestion.analytique.pc.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductionMere {
    private Exercice exercice;
    private Produit produit;
    private List<Production> productions;
    private Double totalProduction; 
}
