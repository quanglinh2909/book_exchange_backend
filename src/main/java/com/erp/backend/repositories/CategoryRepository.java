package com.erp.backend.repositories;

import com.erp.backend.entities.Category;
import com.erp.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
