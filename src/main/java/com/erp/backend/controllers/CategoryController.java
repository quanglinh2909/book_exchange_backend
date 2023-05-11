package com.erp.backend.controllers;

import com.erp.backend.dtos.auth.CategoryDto;
import com.erp.backend.dtos.request.CategoryRequest;
import com.erp.backend.entities.Category;
import com.erp.backend.repositories.CategoryRepository;
import com.erp.backend.services.CategoryServive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
  private  CategoryRepository categoryRepository;
    @Autowired
    private CategoryServive servive;

    @PostMapping("/category/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryRequest request){
       return ResponseEntity.ok(servive.createCategory(request));

    }
    @GetMapping("category/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(servive.getAll());
    }
    public ResponseEntity<?> getListCategory(){
return null;
    }
}
