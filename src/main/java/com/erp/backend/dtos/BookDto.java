package com.erp.backend.dtos;

import com.erp.backend.entities.Author;
import com.erp.backend.entities.Category;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class BookDto {
    @NotBlank(message = "Nhap ten sach")
    private String bookName;
    private String bookDescribe;
    @NotNull(message = "Nhap danh muc")
    private Long category;
    @NotNull(message = "Nhap tac gia")
    private Long author;
}
