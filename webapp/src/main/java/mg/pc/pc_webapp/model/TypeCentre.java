package mg.pc.pc_webapp.model;

import lombok.Data;

@Data
public class TypeCentre {
    private int id_type_centre;
    private String name;
    public TypeCentre(String name) {
        this.name = name;
    }
}
