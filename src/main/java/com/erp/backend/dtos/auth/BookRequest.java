package com.erp.backend.dtos.auth;

import com.erp.backend.entities.Author;
import com.erp.backend.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class BookRequest {

    private String name;
    private String describe;
    private String img;
    private Long category_id;
    private Long author_id;
}
