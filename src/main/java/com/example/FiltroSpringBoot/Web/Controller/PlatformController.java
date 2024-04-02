package com.example.FiltroSpringBoot.Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.FiltroSpringBoot.Domain.Service.PlatformService;
import com.example.FiltroSpringBoot.Persistence.Entity.Platform;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/platforms")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")          //Para cada controlador
@SecurityRequirement(name = "bearerAuth")  //Para cada controlador
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @GetMapping
    public ResponseEntity<List<Platform>> findAllPlatforms() {
        List<Platform> platforms = platformService.findAllPlatforms();
        return ResponseEntity.ok(platforms);
    }

    @GetMapping("/type/{id}")
    public ResponseEntity<List<Platform>> findPlatformsByTypeOfContentId(@PathVariable Long id) {
        List<Platform> platforms = platformService.findByTypeOfContentId(id);
        return ResponseEntity.ok(platforms);
    }

    @PostMapping("/save")
    public ResponseEntity<Platform> savePlatform(@RequestBody Platform platform) {
        ResponseEntity<Platform> responseEntity = platformService.savePlatform(platform);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseEntity.getBody());
    }
}
