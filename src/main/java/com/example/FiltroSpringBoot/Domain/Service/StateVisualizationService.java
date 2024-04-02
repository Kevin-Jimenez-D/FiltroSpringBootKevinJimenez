package com.example.FiltroSpringBoot.Domain.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.FiltroSpringBoot.Persistence.Entity.StateVisualization;

public interface StateVisualizationService {

    // Obtener todos los tipos de contenido
    List<StateVisualization> findAllStateVisualizations();

    // Obtener un tipo de contenido por su identificador
    ResponseEntity<StateVisualization> getStateVisualizationById(Long id);

    //Guardar un nuevo tipo de contenido
    ResponseEntity<StateVisualization> saveStateVisualization(StateVisualization stateVisualization);

    //Editar un tipo de contenido por su identificador
    ResponseEntity<StateVisualization> updateStateVisualizationById(Long id, StateVisualization stateVisualization);

}
