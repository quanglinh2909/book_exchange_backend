package com.erp.backend.repositories;

import com.erp.backend.entities.Book;
import com.erp.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCase(String name, String author);

}