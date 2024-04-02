package com.example.FiltroSpringBoot.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FiltroSpringBoot.Persistence.Entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

    //Save if stateVisualization_ID is finished or abandoned

}
