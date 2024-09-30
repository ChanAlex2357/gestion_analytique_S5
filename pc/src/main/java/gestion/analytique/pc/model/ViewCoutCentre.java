package gestion.analytique.pc.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "v_cout_centre") // Specify the table name if different from the class name
@Data
public class ViewCoutCentre {

    @EmbeddedId
    private ViewCoutCentreId id; // Composite key

    // Optionally, you can define relationships if needed
    @ManyToOne
    @MapsId("id_centre") // Maps the composite key to the Centre entity
    private Centre centre;

    @ManyToOne
    @MapsId("id_nature") // Maps the composite key to the Nature entity
    private Nature natureCharge;

    private Double montant;

    // Default constructor (required by JPA)
    public ViewCoutCentre() {}
}
