package com.erp.backend.controllers;

import com.erp.backend.dtos.auth.BookRequest;
import com.erp.backend.dtos.auth.RegisterRequest;
import com.erp.backend.entities.Book;
import com.erp.backend.repositories.AuthorRepository;
import com.erp.backend.repositories.BookRepository;
import com.erp.backend.repositories.CategoryRepository;
import com.erp.backend.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookService service;
    @PostMapping("/books/upload")
    public ResponseEntity<?> uploadBook(@RequestBody @Valid BookRequest request
                                         ) throws IOException {
       // Book savedBook = service.uploadBook(name,describe,img,id_author,id_category);

        return ResponseEntity.ok(service.uploadBook(request));
      //  return ResponseEntity.ok(savedBook);
    }
}
