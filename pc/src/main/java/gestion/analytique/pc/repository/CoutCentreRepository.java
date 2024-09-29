package gestion.analytique.pc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gestion.analytique.pc.model.ViewCoutCentre;

public interface CoutCentreRepository extends CrudRepository<ViewCoutCentre, Integer> {
    @Query("SELECT dc FROM ViewCoutCentre dc WHERE dc.first_charge_date BETWEEN :start AND :end")
    List<ViewCoutCentre> findAllByExercice(@Param("start") LocalDate start, @Param("end") LocalDate end);    
}
