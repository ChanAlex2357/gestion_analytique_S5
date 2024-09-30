package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.Rubrique;
import gestion.analytique.pc.service.RubriqueService;

import java.util.List;

@RestController
@RequestMapping("/api/rubrique")
public class RubriqueController {
    private final RubriqueService service;

    @Autowired
    public RubriqueController(RubriqueService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Rubrique> getAll() {
        return service.getAll();
    }

    @PostMapping("/insert")
    public ResponseEntity<Rubrique> create(@RequestBody Rubrique rubrique) {
        Rubrique savedRubrique = service.save(rubrique);
        return ResponseEntity.ok(savedRubrique);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rubrique> update(@PathVariable int id, @RequestBody Rubrique rubrique) {
        // Attempt to retrieve the existing Rubrique
        return service.getById(id)
                .map(existingRubrique -> {
                    // Update fields as needed
                    existingRubrique.setName(rubrique.getName()); // Example field
                    // existingRubrique.setDescription(rubrique.getDescription()); // Example field
                    Rubrique updatedRubrique = service.save(existingRubrique);
                    return ResponseEntity.ok(updatedRubrique);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
