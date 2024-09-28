package gestion.analytique.pc.model;

import java.io.Serializable;
import java.util.Objects;

public class CentreProductionId implements Serializable {

    private int typeCentreProduction;
    private int produit;
    private int centre;
    private int idCentreProduction;

    // Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentreProductionId that = (CentreProductionId) o;
        return typeCentreProduction == that.typeCentreProduction &&
               produit == that.produit &&
               centre == that.centre &&
               idCentreProduction == that.idCentreProduction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeCentreProduction, produit, centre, idCentreProduction);
    }
}
