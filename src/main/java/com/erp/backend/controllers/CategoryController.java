package com.erp.backend.controllers;

import com.erp.backend.dtos.auth.CategoryDto;
import com.erp.backend.entities.Category;
import com.erp.backend.repositories.CategoryRepository;
import com.erp.backend.services.CategoryServive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
  private  CategoryRepository categoryRepository;
    @Autowired
    private CategoryServive servive;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto dto){
       return ResponseEntity.ok(servive.createCategory(dto));

    }
    public ResponseEntity<?> getListCategory(){
return null;
    }
}
