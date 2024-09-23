package mg.pc.pc_webapp.model;

import lombok.Data;

@Data
public class Centre {

    private int id_centre;
    private TypeCentre typeCentre;

    private String name;

    public Centre(TypeCentre typeCentre, String name) {
        this.typeCentre = typeCentre;
        this.name = name;
    }
}
