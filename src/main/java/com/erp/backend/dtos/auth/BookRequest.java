package com.erp.backend.dtos.auth;

import com.erp.backend.entities.Author;
import com.erp.backend.entities.Category;
import com.erp.backend.entities.ImageModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class BookRequest {




    private String name;
    private String describe;
    private String img;
    private String category;
    private String author;
}