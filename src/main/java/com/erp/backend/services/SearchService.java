package com.erp.backend.services;

import com.erp.backend.dtos.auth.SearchDto;
import com.erp.backend.entities.Book;
import com.erp.backend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;



import java.util.List;
@Service
public class SearchService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> searchBooks(SearchDto keyword) {
        return bookRepository.findByBookNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCase(keyword.getKeyword(), keyword.getKeyword());
    }
}
