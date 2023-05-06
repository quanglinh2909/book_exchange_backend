package com.erp.backend.services;

import com.erp.backend.entities.Author;
import com.erp.backend.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthorById(long id){
        return authorRepository.getAuthorById(id);
    }
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

}
