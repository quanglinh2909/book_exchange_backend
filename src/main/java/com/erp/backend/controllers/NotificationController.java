package com.erp.backend.controllers;

import com.erp.backend.dtos.request.CommentRequest;
import com.erp.backend.dtos.request.NotificationRequest;
import com.erp.backend.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class NotificationController {
    @Autowired
    NotificationService service;
    @PostMapping(value = {"/notify/create"})
    public ResponseEntity<?> createComment(@RequestAttribute("email") String email, @RequestBody NotificationRequest request){
        return  ResponseEntity.ok(service.createNotification(email,request));
    }
    @PutMapping({"/notify/{idNotify}"})
    public ResponseEntity<?> read(@PathVariable(value = "idNotify") Long idNotify){
        return ResponseEntity.ok(service.read(idNotify));
    }
    @GetMapping({"/notify/get/{idUser}"})
    public ResponseEntity<?> getAll(@PathVariable(value = "idUser") Long iduser){
        return ResponseEntity.ok(service.getAll(iduser));

    }
}
