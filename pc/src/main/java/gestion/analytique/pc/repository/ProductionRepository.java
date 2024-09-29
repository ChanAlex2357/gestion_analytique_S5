package gestion.analytique.pc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gestion.analytique.pc.model.Production;

public interface ProductionRepository extends CrudRepository<Production,Integer>{
    @Query("SELECT * FROM production WHERE c.date_production BETWEEN :start AND :end")
    List<Production> findProductionByExercice(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
