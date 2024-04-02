package com.example.FiltroSpringBoot.Domain.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FiltroSpringBoot.Domain.Repository.StateVisualizationRepository;
import com.example.FiltroSpringBoot.Domain.Service.StateVisualizationService;
import com.example.FiltroSpringBoot.Persistence.Entity.StateVisualization;

@Service // Indica que la clase es un servicio de Spring
public class StateVisualizationImpl implements StateVisualizationService {

    @Autowired // Inyecta una instancia de TypeOfContentRepository automáticamente
    private StateVisualizationRepository stateVisualizationRepository;

    @Override
    public List<StateVisualization> findAllStateVisualizations() {
        return stateVisualizationRepository.findAll();
    }

    @Override
    public ResponseEntity<StateVisualization> getStateVisualizationById(Long id) {
        Optional<StateVisualization> stateVisualization = stateVisualizationRepository.findById(id);
        return stateVisualization.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<StateVisualization> saveStateVisualization(StateVisualization stateVisualization) {
        stateVisualization = stateVisualizationRepository.save(stateVisualization);
        return ResponseEntity.ok(stateVisualization);
    }

    @Override
    public ResponseEntity<StateVisualization> updateStateVisualizationById(Long id,
            StateVisualization stateVisualization) {
                Optional<StateVisualization> existingStateVisualizationOptional = stateVisualizationRepository.findById(id);
                if (existingStateVisualizationOptional.isPresent()) {
                    StateVisualization existingStateVisualization = existingStateVisualizationOptional.get();
                    existingStateVisualization.setStateVisualization(stateVisualization.getStateVisualization());
                    stateVisualizationRepository.save(existingStateVisualization);
                    return ResponseEntity.ok(existingStateVisualization);
                } else {
                    return ResponseEntity.notFound().build();
                }
    }

}
