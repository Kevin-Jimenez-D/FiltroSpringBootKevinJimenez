package com.example.FiltroSpringBoot.Domain.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FiltroSpringBoot.Domain.Repository.TypeOfContentRepository;
import com.example.FiltroSpringBoot.Domain.Service.TypeOfContentService;
import com.example.FiltroSpringBoot.Persistence.Entity.TypeOfContent;

@Service // Indica que la clase es un servicio de Spring
public class TypeOfContentImpl implements TypeOfContentService {

        @Autowired // Inyecta una instancia de OperationRepository automáticamente
        private TypeOfContentRepository typeOfContentRepository;

        @Override
        public List<TypeOfContent> findAllTypeOfContents() {
            return typeOfContentRepository.findAll();
        }

        @Override
        public ResponseEntity<TypeOfContent> getTypeOfContentById(String id) {
            Optional<TypeOfContent> typeOfContent = typeOfContentRepository.findById(id);
            return typeOfContent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @Override
        public ResponseEntity<TypeOfContent> getTypeOfContentByName(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getTypeOfContentByName'");
        }

        @Override
        public ResponseEntity<TypeOfContent> saveTypeOfContent(TypeOfContent typeOfContent) {
            String name = typeOfContent.getName();
            if (name == null || name.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            typeOfContent= typeOfContentRepository.save(typeOfContent);
            return ResponseEntity.ok(typeOfContent);
        }

}
