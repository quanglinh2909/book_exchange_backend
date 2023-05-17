package com.erp.backend.controllers;

import com.erp.backend.dtos.request.CommentRequest;
import com.erp.backend.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CommentController {
    @Autowired
    CommentService service;
    @PostMapping(value = {"/comment/create"})
    public ResponseEntity<?> createComment(@RequestBody CommentRequest request){
        return  ResponseEntity.ok(service.createComment(request));
    }
    @GetMapping(value = {"/comment/{idBook}"})
    public ResponseEntity<?> getListComment(@PathVariable Long idBook){
        return ResponseEntity.ok(service.getListComment(idBook));
    }
}
