package com.example.FiltroSpringBoot.Domain.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.FiltroSpringBoot.Persistence.DTO.TypeOfContentDTO;
import com.example.FiltroSpringBoot.Persistence.Entity.TypeOfContent;

public interface TypeOfContentService {

    //Obtener todos los tipos de contenido
    List<TypeOfContent> findAllTypeOfContents();

    //Obtener un tipo de contenido por su identificador
    ResponseEntity<TypeOfContent> getTypeOfContentById(String id);

    //Obtener un tipo de contenido por su nombre
    ResponseEntity<TypeOfContent> getTypeOfContentByName(String name);

    //Guardar un nuevo tipo de contenido
    ResponseEntity<TypeOfContent> saveTypeOfContent(TypeOfContent typeOfContent);
}
