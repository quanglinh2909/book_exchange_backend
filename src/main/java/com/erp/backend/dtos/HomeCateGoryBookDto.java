package com.erp.backend.dtos;

import com.erp.backend.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeCateGoryBookDto {
    String name;
    List<Book> listBook;
}
