package com.example.FiltroSpringBoot.Domain.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FiltroSpringBoot.Persistence.Entity.Platform;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {

    //Save depends of typeOfContent, Select
    List<Platform> findByTypeOfContentId(Long id);

}
