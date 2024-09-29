package gestion.analytique.pc.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import gestion.analytique.pc.model.Centre;
import gestion.analytique.pc.model.CentreProductionId;
import gestion.analytique.pc.model.Produit;

public interface CentreProductionRepository extends CrudRepository<CentreProductionId,Integer>{
    @Query("SELECT cp.centre FROM CentreProduction cp WHERE cp.produit = :produit")
    List<Centre> findCentresByProduit(Produit produit);
}
