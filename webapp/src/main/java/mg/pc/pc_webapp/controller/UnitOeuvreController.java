package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.UnitOeuvre;
import gestion.analytique.pc.service.UnitOeuvreService;

import java.util.List;

@RestController
@RequestMapping("/unitoeuvre")
public class UnitOeuvreController {
    private final UnitOeuvreService service;

    @Autowired
    public UnitOeuvreController(UnitOeuvreService service) {
        this.service = service;
    }

    @GetMapping
    public List<UnitOeuvre> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<UnitOeuvre> create(@RequestBody UnitOeuvre unitOeuvre) {
        UnitOeuvre savedUnitOeuvre = service.save(unitOeuvre);
        return ResponseEntity.ok(savedUnitOeuvre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
