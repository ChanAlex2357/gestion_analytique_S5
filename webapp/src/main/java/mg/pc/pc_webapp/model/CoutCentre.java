package mg.pc.pc_webapp.model;

import lombok.Data;

@Data
public class CoutCentre {

    private int id_centre;
    private Nature nature; 
    private double total_cout_centre;
    public CoutCentre(Nature nature, double total_cout_centre) {
        this.nature = nature;
        this.total_cout_centre = total_cout_centre;
    }
}
