package gestion.analytique.pc.repository;

import org.springframework.data.repository.CrudRepository;
import gestion.analytique.pc.model.Production;

public interface ProductionRepository extends CrudRepository<Production,Integer>{
    // @Query("SELECT prd FROM production WHERE c.date_charge BETWEEN :start AND :end")
    // List<Production> findAllByExercice(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
