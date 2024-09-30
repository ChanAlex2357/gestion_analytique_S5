package gestion.analytique.pc.model;

import java.util.HashMap;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CentreProductionMere {
    private HashMap< Produit , List<CentreProduction>> centreProduit;
}
