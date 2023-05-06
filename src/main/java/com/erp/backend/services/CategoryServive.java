package com.erp.backend.services;

import com.erp.backend.dtos.auth.CategoryDto;
import com.erp.backend.entities.Category;
import com.erp.backend.exceptions.ResourceNotFoundException;
import com.erp.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.util.List;

@Service
public class CategoryServive {
    @Autowired
    private CategoryRepository categoryRepository;




    public Category createCategory (@Valid CategoryDto request){
        if (request.getName() == null || request.getName().isBlank()) {
            throw new ResourceNotFoundException("Tên thể loại không hợp lệ");
        }


        Category category = Category.builder().name(request.getName()).description(request.getDescription()).build();

    //   var user = repository.findByEmail(request.getEmail())
      //          .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Category saveCategory = categoryRepository.save(category);
      return   saveCategory;
    }
    public List<Category> getCategory(){return categoryRepository.findAll();}

    public Category getCategoryById(long id){
        return categoryRepository.getCategoryById(id);
    }

}
