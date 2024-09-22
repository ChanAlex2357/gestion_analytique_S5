package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.Rubrique;
import gestion.analytique.pc.service.RubriqueService;

import java.util.List;

@RestController
@RequestMapping("/rubrique")
public class RubriqueController {
    private final RubriqueService service;

    @Autowired
    public RubriqueController(RubriqueService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rubrique> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Rubrique> create(@RequestBody Rubrique rubrique) {
        Rubrique savedRubrique = service.save(rubrique);
        return ResponseEntity.ok(savedRubrique);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
