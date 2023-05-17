package com.erp.backend.repositories;

import com.erp.backend.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("select a from Author a where  a.author_id = ?1")
    public Author getAuthorById(long id);
    Optional<Author> findByName(String name);

}
