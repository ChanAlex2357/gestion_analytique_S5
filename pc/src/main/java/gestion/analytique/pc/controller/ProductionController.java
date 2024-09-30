package gestion.analytique.pc.controller;

import gestion.analytique.pc.model.Production;
import gestion.analytique.pc.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductionController {

    private final ProductionService productionService;

    @Autowired
    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    // GET: Retrieve all productions
    @GetMapping("/list")
    public List<Production> getAll() {
        return productionService.getAll();
    }

    // POST: Create a new production
    @PostMapping("/insert")
    public ResponseEntity<Production> create(@RequestBody Production production) throws Exception {
        if (production.getQuantite() == null || production.getQuantite().doubleValue() <= 0) {
            throw new Exception("La quantité doit être supérieure à 0");
        }
        System.out.println("Requête reçue : " + production);
        Production savedProduction = productionService.save(production);
        return ResponseEntity.ok(savedProduction);
    }

    // PUT: Update an existing production
    @PutMapping("/update/{id}")
    public ResponseEntity<Production> update(@PathVariable int id, @RequestBody Production production) {
        // Check if production's quantity is valid
        if (production.getQuantite() == null || production.getQuantite().doubleValue() <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Production updatedProduction = productionService.update(id, production);
        return ResponseEntity.ok(updatedProduction);
    }

    // DELETE: Delete a production by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        System.out.println("Id de production à supprimer : " + id);
        productionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
