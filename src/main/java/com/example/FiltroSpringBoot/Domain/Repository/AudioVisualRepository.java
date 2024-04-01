package com.example.FiltroSpringBoot.Domain.Repository;

import com.example.FiltroSpringBoot.Persistence.Entity.AudioVisual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioVisualRepository extends JpaRepository<AudioVisual, String> {

    //CRUD

}
