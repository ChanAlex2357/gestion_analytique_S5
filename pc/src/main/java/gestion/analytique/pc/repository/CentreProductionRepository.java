package gestion.analytique.pc.repository;

import org.springframework.data.repository.CrudRepository;

import gestion.analytique.pc.model.CentreProductionId;

public interface CentreProductionRepository extends CrudRepository<CentreProductionId,Integer>{
    
}
