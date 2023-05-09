package com.erp.backend.controllers;

import com.erp.backend.dtos.AuthorDto;
import com.erp.backend.dtos.request.AuthorRequest;
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
    @GetMapping("author/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
