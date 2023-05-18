package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.BookDTO;
import com.erp.backend.entities.Book;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BookDTOMapper implements Function<Book, BookDTO> {

    @Override
    public BookDTO apply(Book book) {
        return new BookDTO(book.getBookId(), book.getBookName(), book.getBookDescribe(),book.getCategory().getName(),book.getAuthor().getName(),book.getProductImages(),book.getUserCreate(),book.getCreatedAt(),book.getListComment());
    }
}
