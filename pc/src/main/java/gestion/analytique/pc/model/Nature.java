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
@Table(name = "nature") 
public class Nature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nature;

    private String name ;

    //Construtor : 
    @Builder 
    public Nature(int id_nature,String name){
        this.id_nature = id_nature;
        this.name = name;
    }
}