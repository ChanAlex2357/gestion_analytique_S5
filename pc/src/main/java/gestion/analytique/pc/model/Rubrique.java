package gestion.analytique.pc.model;

//All the importation 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rubrique") 
public class Rubrique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rubique;

    private String name ;
    private int id_unit_oeuvre ; 
    private int id_nature;

    //Construtor : 
    @Builder 
    public Rubrique(String name,int id_unit_oeuvre,int id_nature){
        this.name = name;
        this.id_unit_oeuvre = id_unit_oeuvre;
        this.id_nature = id_nature;
    }
}