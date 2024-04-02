package com.example.FiltroSpringBoot.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.FiltroSpringBoot.Domain.Service.CostumerService;
import com.example.FiltroSpringBoot.Persistence.Entity.Costumer;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumers")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")            //Para cada controlador
@SecurityRequirement(name = "bearerAuth")   //Para cada controlador
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @GetMapping
    public ResponseEntity<List<Costumer>> findAllCostumers() {
        List<Costumer> costumers = costumerService.findAllCostumers();
        return ResponseEntity.ok(costumers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Costumer> getCostumerById(@PathVariable Long id) {
        ResponseEntity<Costumer> responseEntity = costumerService.getCostumerById(id);
        return responseEntity;
    }

    @PostMapping("/save")
    public ResponseEntity<Costumer> saveCostumer(@RequestBody Costumer costumer) {
        ResponseEntity<Costumer> responseEntity = costumerService.saveCostumer(costumer);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseEntity.getBody());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Costumer> updateCostumer(@PathVariable Long id, @RequestBody Costumer costumer) {
        return costumerService.updateCostumer(id, costumer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCostumerById(@PathVariable Long id) {
        ResponseEntity<Void> responseEntity = costumerService.deleteCostumerById(id);
        return responseEntity;
    }

}
