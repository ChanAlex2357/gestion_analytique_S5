package gestion.analytique.pc.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gestion.analytique.pc.model.DetailCharge;

public interface DetailChargeRepository extends CrudRepository<DetailCharge, Integer> {
    @Query("SELECT SUM(dc.montant) FROM DetailCharge dc WHERE dc.rubrique.id = :idRubrique")
    Double sumMontantByRubriqueId(@Param("idRubrique") int idRubrique);
}
