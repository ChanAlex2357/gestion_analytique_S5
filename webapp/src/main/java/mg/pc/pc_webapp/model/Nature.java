package mg.pc.pc_webapp.model;

import lombok.Data;

@Data 
public class Nature {

    private int id_nature;

    private String name ;
    public Nature(int id_nature,String name){
        this.id_nature = id_nature;
        this.name = name;
    }
}