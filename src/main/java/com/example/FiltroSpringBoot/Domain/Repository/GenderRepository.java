package com.example.FiltroSpringBoot.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FiltroSpringBoot.Persistence.Entity.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

    //Save, Select

}
