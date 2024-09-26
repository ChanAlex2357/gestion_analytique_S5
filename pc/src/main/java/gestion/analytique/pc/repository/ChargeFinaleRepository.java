package gestion.analytique.pc.repository;

import org.springframework.data.repository.CrudRepository;
import gestion.analytique.pc.model.Charge;

public interface ChargeFinaleRepository extends CrudRepository<Charge, Integer> {
}
