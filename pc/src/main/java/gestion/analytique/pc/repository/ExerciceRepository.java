package gestion.analytique.pc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.analytique.pc.model.Exercice;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
    // Custom query methods (if any) can be defined here
}
