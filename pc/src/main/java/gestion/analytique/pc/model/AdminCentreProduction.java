package gestion.analytique.pc.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminCentreProduction {
    private Produit produit;
    private Centre[]  centres;

    @Builder
    public AdminCentreProduction(Produit produit){
        setProduit(produit);
    }
}
