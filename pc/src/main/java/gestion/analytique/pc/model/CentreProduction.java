package gestion.analytique.pc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "centre_production")
@NoArgsConstructor
public class CentreProduction {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_type_centre_production")
    private TypeCentreProduction typeCentreProduction;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_centre")
    private Centre centre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCentreProduction;
}
