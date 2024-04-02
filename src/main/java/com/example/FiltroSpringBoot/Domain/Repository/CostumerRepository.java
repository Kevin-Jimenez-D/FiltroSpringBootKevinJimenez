package com.example.FiltroSpringBoot.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FiltroSpringBoot.Persistence.Entity.Costumer;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {

    //CRUD, Select by propierties in all tables

}
