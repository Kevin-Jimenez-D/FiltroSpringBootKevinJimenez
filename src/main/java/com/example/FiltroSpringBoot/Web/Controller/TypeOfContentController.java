package com.example.FiltroSpringBoot.Web.Controller;

import java.util.List;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.FiltroSpringBoot.Domain.Service.TypeOfContentService;
import com.example.FiltroSpringBoot.Persistence.DTO.TypeOfContentDTO;
import com.example.FiltroSpringBoot.Persistence.Entity.TypeOfContent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/typeOfContent")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")            //Para cada controlador
@SecurityRequirement(name = "bearerAuth")   //Para cada controlador
public class TypeOfContentController {

    @Autowired
    TypeOfContentService typeOfContentService;

    @GetMapping
    public List<TypeOfContent> findAllTypeOfContents() {
        return typeOfContentService.findAllTypeOfContents();
    }

    @PostMapping("/save")
    public void saveTypeOfContent(@RequestBody TypeOfContent typeOfContent) {
        typeOfContentService.saveTypeOfContent(typeOfContent);
    }
    

}
