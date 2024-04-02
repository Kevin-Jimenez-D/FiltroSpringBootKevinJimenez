package com.example.FiltroSpringBoot.Domain.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.FiltroSpringBoot.Persistence.Entity.Platform;

public interface PlatformService {

    //Obtener todas las plataformas
    List<Platform> findAllPlatforms();

    //Listar por tipo de contenido
    List<Platform> findByTypeOfContentId(Long id);

    //Guardar una nueva plataforma
    ResponseEntity<Platform> savePlatform(Platform platform);

}
