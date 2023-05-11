package com.erp.backend.repositories;

import com.erp.backend.entities.Category;
import com.erp.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c where c.category_id = ?1")
    public Category getCategoryById(long id);
    Optional<Category> findByName(String name);

}
