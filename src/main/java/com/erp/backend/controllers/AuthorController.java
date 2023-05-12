package com.erp.backend.controllers;

import com.erp.backend.dtos.AuthorDto;
import com.erp.backend.dtos.request.AuthorRequest;
import com.erp.backend.dtos.request.UpdateAuthorRequest;
import com.erp.backend.dtos.request.UpdateCategoryRequest;
import com.erp.backend.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
    AuthorService service;
    @PostMapping("author/create")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody @Valid AuthorRequest request){
        return ResponseEntity.ok(service.createAuthor(request));
    }
    @PostMapping("/author/update")
    public ResponseEntity<?> updateAuthor(@Valid @RequestBody UpdateAuthorRequest request){
        return ResponseEntity.ok(service.updateAuthor(request));

    }
    @DeleteMapping("/author/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(value = "id") Long idAuthor){
        return ResponseEntity.ok(service.deleteAuthor(idAuthor));
    }
    @GetMapping("author/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
