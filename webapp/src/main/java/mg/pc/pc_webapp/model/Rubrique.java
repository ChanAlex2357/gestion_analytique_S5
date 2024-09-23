package mg.pc.pc_webapp.model;

import lombok.Data;

@Data
public class Rubrique {

    private int id_rubrique;

    private String name; 

    private UnitOeuvre unitOeuvre; 
    private Nature nature; 

    public Rubrique(String name, UnitOeuvre unitOeuvre, Nature nature) {
        this.name = name;
        this.unitOeuvre = unitOeuvre;
        this.nature = nature;
    }
}
