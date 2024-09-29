package gestion.analytique.pc.model;

import java.util.HashMap;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CentreProductionMere {
    private HashMap< Produit , CentreProduction> centreProduit;
}
