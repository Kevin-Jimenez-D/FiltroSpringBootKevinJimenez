package com.example.FiltroSpringBoot.Domain.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FiltroSpringBoot.Domain.Repository.CostumerRepository;
import com.example.FiltroSpringBoot.Domain.Service.CostumerService;
import com.example.FiltroSpringBoot.Persistence.Entity.Costumer;

@Service // Indica que la clase es un servicio de Spring
public class CostumerImpl implements CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    @Override
    public List<Costumer> findAllCostumers() {
        return costumerRepository.findAll();
    }

    @Override
    public ResponseEntity<Costumer> getCostumerById(Long id) {
        Optional<Costumer> costumer = costumerRepository.findById(id);
        return costumer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Costumer> saveCostumer(Costumer costumer) {
        Costumer savedCostumer = costumerRepository.save(costumer);
        return ResponseEntity.ok(savedCostumer);
    }

    @Override
    public ResponseEntity<Costumer> updateCostumer(Long id, Costumer costumer) {
        if (!costumerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        costumer.setId(id);
        Costumer updatedCostumer = costumerRepository.save(costumer);
        return ResponseEntity.ok(updatedCostumer);
    }

    @Override
    public ResponseEntity<Void> deleteCostumerById(Long id) {
        if (costumerRepository.existsById(id)) {
            costumerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
