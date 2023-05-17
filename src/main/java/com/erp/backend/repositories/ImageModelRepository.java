package com.erp.backend.repositories;

import com.erp.backend.entities.Category;
import com.erp.backend.entities.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageModelRepository  extends JpaRepository<ImageModel, Long> {
}
