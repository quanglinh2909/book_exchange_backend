package com.erp.backend.dtos.resonse;

import com.erp.backend.dtos.auth.BookDto;
import com.erp.backend.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeBook {
    private String title;
    private List<BookDto> listBook;

}
