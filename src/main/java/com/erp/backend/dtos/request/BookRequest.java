package com.erp.backend.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String name;
    private String description;
<<<<<<< HEAD
    private Long idAuthor;
=======
    private String authorName;
    private Long idUserCreate;
>>>>>>> 395a5e0ecade2da5532c3470fdc2b8df126d5f70
    private Long idCategory;
}
