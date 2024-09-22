package gestion.analytique.pc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "coutcentre")
public class CoutCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_centre;

    @ManyToOne
    @JoinColumn(name = "id_nature", nullable = false) 
    private Nature nature; 

    @Column(name = "total_cout_centre")
    private double total_cout_centre;

    // Constructor
    @Builder
    public CoutCentre(Nature nature, double total_cout_centre) {
        this.nature = nature;
        this.total_cout_centre = total_cout_centre;
    }
}
