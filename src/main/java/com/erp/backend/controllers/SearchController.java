package com.erp.backend.controllers;

import com.erp.backend.dtos.auth.SearchDto;
import com.erp.backend.entities.Book;
import com.erp.backend.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/")
public class SearchController {
    @Autowired

    private SearchService service;

    @PostMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@Valid SearchDto  keyword) {
        List<Book> books = service.searchBooks(keyword);

        return ResponseEntity.ok(books);
    }
}
