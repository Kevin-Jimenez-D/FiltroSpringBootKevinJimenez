package com.example.FiltroSpringBoot.Domain.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FiltroSpringBoot.Domain.Repository.PlatformRepository;
import com.example.FiltroSpringBoot.Domain.Service.PlatformService;
import com.example.FiltroSpringBoot.Persistence.Entity.Platform;

@Service
public class PlatformImpl implements PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findAllPlatforms() {
        return platformRepository.findAll();
    }

    @Override
    public List<Platform> findByTypeOfContentId(Long id) {
        return platformRepository.findByTypeOfContentId(id);
    }

    @Override
    public ResponseEntity<Platform> savePlatform(Platform platform) {
        Platform savedPlatform = platformRepository.save(platform);
        return ResponseEntity.ok(savedPlatform);
    }

}
