package com.erp.backend.services;

import com.erp.backend.dtos.CategoryDto;
import com.erp.backend.dtos.mappers.CategoryDtoMapper;
import com.erp.backend.dtos.request.CategoryRequest;
import com.erp.backend.entities.Author;
import com.erp.backend.entities.Category;
import com.erp.backend.exceptions.ExitException;
import com.erp.backend.exceptions.ResourceNotFoundException;
import com.erp.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServive {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    CategoryDtoMapper mapper;

    public CategoryDto createCategory (@Valid CategoryRequest request){
        Optional<Category> optionalCategory=categoryRepository.findByName(request.getName());
        if(optionalCategory.isPresent()){
            throw new ExitException(HttpStatus.BAD_REQUEST,"Category is exits");
        }
        Category category=Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        Category save=categoryRepository.save(category);
        return mapper.apply(save);
    }
    public List<Category> getCategory(){return categoryRepository.findAll();}

    public Category getCategoryById(long id){
        return categoryRepository.getCategoryById(id);
    }
    public List<CategoryDto> getAll(){
        List<Category> list=categoryRepository.findAll();
        List<CategoryDto> listResult=list.stream().map(mapper::apply).collect(Collectors.toList());
        return listResult;
    }
}
