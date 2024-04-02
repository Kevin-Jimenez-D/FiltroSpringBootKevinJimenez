package com.example.FiltroSpringBoot.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FiltroSpringBoot.Domain.Service.StateVisualizationService;
import com.example.FiltroSpringBoot.Persistence.Entity.StateVisualization;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stateVisualizations")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")            //Para cada controlador
@SecurityRequirement(name = "bearerAuth")   //Para cada controlador
public class StateVisualizationController {

    @Autowired
    private StateVisualizationService stateVisualizationService;

    @GetMapping
    public ResponseEntity<List<StateVisualization>> getAllStateVisualizations() {
        List<StateVisualization> stateVisualizations = stateVisualizationService.findAllStateVisualizations();
        return ResponseEntity.ok(stateVisualizations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateVisualization> getStateVisualizationById(@PathVariable Long id) {
        ResponseEntity<StateVisualization> responseEntity = stateVisualizationService.getStateVisualizationById(id);
        return responseEntity;
    }

    @PostMapping("/save")
    public ResponseEntity<StateVisualization> saveStateVisualization(@RequestBody StateVisualization stateVisualization) {
        ResponseEntity<StateVisualization> responseEntity = stateVisualizationService.saveStateVisualization(stateVisualization);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseEntity.getBody());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateVisualization> updateStateVisualization(@PathVariable Long id, @RequestBody StateVisualization stateVisualization) {
        ResponseEntity<StateVisualization> responseEntity = stateVisualizationService.updateStateVisualizationById(id, stateVisualization);
        return responseEntity;
    }

}
