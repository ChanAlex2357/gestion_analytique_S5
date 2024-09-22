package gestion.analytique.pc.repository;

import org.springframework.data.repository.CrudRepository;
import gestion.analytique.pc.model.Nature;

public interface NatureRepository extends CrudRepository<Nature, Integer> {
    
}
