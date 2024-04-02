package com.example.FiltroSpringBoot.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FiltroSpringBoot.Persistence.Entity.TypeOfContent;

@Repository
public interface TypeOfContentRepository extends JpaRepository<TypeOfContent, Long> {

    //Save, Select
    TypeOfContent findByName(String name); // Agrega este método para buscar por nombre
}
