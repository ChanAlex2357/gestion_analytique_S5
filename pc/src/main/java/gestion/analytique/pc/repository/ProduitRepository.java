package gestion.analytique.pc.repository;

import org.springframework.data.repository.CrudRepository;
import gestion.analytique.pc.model.Produit;

public interface ProduitRepository extends CrudRepository<Produit,Integer>{
    
}
