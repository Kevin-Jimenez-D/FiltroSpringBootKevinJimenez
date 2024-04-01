package com.example.FiltroSpringBoot.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FiltroSpringBoot.Persistence.Entity.TypeOfContent;

@Repository
public interface TypeOfContentRepository extends JpaRepository<TypeOfContent, String> {

    //Save, Select

}
