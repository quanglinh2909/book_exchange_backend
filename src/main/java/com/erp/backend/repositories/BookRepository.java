package com.erp.backend.repositories;

import com.erp.backend.entities.Book;
import com.erp.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
