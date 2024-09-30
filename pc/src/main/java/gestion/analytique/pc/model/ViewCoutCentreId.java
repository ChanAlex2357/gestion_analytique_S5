package gestion.analytique.pc.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class ViewCoutCentreId implements Serializable {
    @Column(name = "id_centre")
    private Integer id_centre; // Reference to the Centre entity's ID
    @Column(name = "id_centre")
    private Integer id_nature; // Reference to the Nature entity's ID
    

    // Default constructor (required by JPA)
    public ViewCoutCentreId() {}

    // Override equals() and hashCode() for proper comparison in JPA
    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (!(o instanceof ViewCoutCentreId)) return false;
    //     ViewCoutCentreId that = (ViewCoutCentreId) o;
    //     return id_centre.equals(that.id_centre) && id_nature.equals(that.id_nature);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id_centre, id_nature);
    // }
}
