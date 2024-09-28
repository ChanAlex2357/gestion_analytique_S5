package gestion.analytique.pc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "type_centre_production")
public class TypeCentreProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeCentreProduction;

    private String designation;
}
