package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.UnitOeuvre;
import gestion.analytique.pc.service.UnitOeuvreService;
import java.util.List;

@RestController
@RequestMapping("/api/unitoeuvre")
@CrossOrigin(origins = "http://localhost:5173")
public class UnitOeuvreController {
    private final UnitOeuvreService service;

    @Autowired
    public UnitOeuvreController(UnitOeuvreService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<UnitOeuvre> getAll() {
        return service.getAll();
    }

    @PostMapping("/insert")
    public ResponseEntity<UnitOeuvre> create(@RequestBody UnitOeuvre unitOeuvre) throws Exception{
        if (unitOeuvre.getName() == null || unitOeuvre.getName().isEmpty()) {
            throw new Exception("Le nom ne peut pas être vide");
        }
        System.out.println("Requête reçue : " + unitOeuvre);
        UnitOeuvre savedUnitOeuvre = service.save(unitOeuvre);
        return ResponseEntity.ok(savedUnitOeuvre);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UnitOeuvre> update(@PathVariable int id, @RequestBody UnitOeuvre unitOeuvre) {
        // Optional: Check if the unit with the given id exists
        if (unitOeuvre.getName() == null || unitOeuvre.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        
        UnitOeuvre updatedUnitOeuvre = service.update(id, unitOeuvre);
        return ResponseEntity.ok(updatedUnitOeuvre);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        System.out.println("Id supp : "+id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
