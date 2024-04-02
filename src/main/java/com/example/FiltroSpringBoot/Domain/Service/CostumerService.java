package com.example.FiltroSpringBoot.Domain.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.FiltroSpringBoot.Persistence.Entity.Costumer;

public interface CostumerService {

    //Obtener todos los clientes
    List<Costumer> findAllCostumers();

    //Los ResponseEntity representa toda la respuesta HTTP, incluyendo el código de estado, los encabezados y el cuerpo de la respuesta.

    // Método para obtener un cliente por su identificador
    ResponseEntity<Costumer> getCostumerById(Long id);

    // Método para guardar un nuevo cliente
    ResponseEntity<Costumer> saveCostumer(Costumer costumer);

    // Método para actualizar un cliente existente por su identificador
    ResponseEntity<Costumer> updateCostumer(Long id, Costumer costumer);

    // Método para eliminar un cliente por su identificador
    ResponseEntity<Void> deleteCostumerById(Long id);


}
