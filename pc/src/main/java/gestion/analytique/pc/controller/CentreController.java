package gestion.analytique.pc.controller;

import gestion.analytique.pc.model.Centre;
import gestion.analytique.pc.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centre")
@CrossOrigin(origins = "http://localhost:5173")
public class CentreController {
    
    private final CentreService centreService;

    @Autowired
    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }

    // GET: Retrieve all centres
    @GetMapping("/list")
    public List<Centre> getAll() {
        return centreService.getAll();
    }

    // POST: Create a new centre
    @PostMapping("/insert")
    public ResponseEntity<Centre> create(@RequestBody Centre centre) throws Exception {
        if (centre.getName() == null || centre.getName().isEmpty()) {
            throw new Exception("Le nom du centre ne peut pas être vide");
        }
        System.out.println("Requête reçue : " + centre);
        Centre savedCentre = centreService.save(centre);
        return ResponseEntity.ok(savedCentre);
    }

    // PUT: Update an existing centre
    @PutMapping("/update/{id}")
    public ResponseEntity<Centre> update(@PathVariable int id, @RequestBody Centre centre) {
        if (centre.getName() == null || centre.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        Centre updatedCentre = centreService.update(id, centre);
        if (updatedCentre != null) {
            return ResponseEntity.ok(updatedCentre);
        } else {
            return ResponseEntity.notFound().build();  // Si le centre n'existe pas
        }
    }

    // DELETE: Delete a centre by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        System.out.println("Id du centre à supprimer : " + id);
        centreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
