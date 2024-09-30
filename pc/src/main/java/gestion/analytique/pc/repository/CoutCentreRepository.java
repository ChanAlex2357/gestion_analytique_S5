package gestion.analytique.pc.repository;
import org.springframework.data.repository.CrudRepository;
import gestion.analytique.pc.model.ViewCoutCentre;
import gestion.analytique.pc.model.ViewCoutCentreId;

public interface CoutCentreRepository extends CrudRepository<ViewCoutCentre, ViewCoutCentreId> {
    // @Query("SELECT new gestion.analytique.pc.model.ViewCoutCentre(c, n, SUM(dc.montant)) " +
    //        "FROM Detail_charge dc " +
    //        "JOIN dc.centre c " +
    //        "JOIN dc.nature n " +
    //        "WHERE dc.date_charge BETWEEN :startDate AND :endDate " +
    //        "GROUP BY c, n")
    // List<ViewCoutCentre> findAllByExercice(@Psaram("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);    
}
