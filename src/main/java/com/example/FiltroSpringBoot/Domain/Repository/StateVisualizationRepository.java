package com.example.FiltroSpringBoot.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FiltroSpringBoot.Persistence.Entity.StateVisualization;

@Repository
public interface StateVisualizationRepository extends JpaRepository<StateVisualization, Long> {

//Sellect, Save, Update

}
