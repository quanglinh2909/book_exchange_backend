package com.erp.backend.services;


import com.erp.backend.dtos.auth.BookRequest;
import com.erp.backend.entities.Author;
import com.erp.backend.entities.Book;
import com.erp.backend.entities.Category;
import com.erp.backend.repositories.AuthorRepository;
import com.erp.backend.repositories.BookRepository;
import com.erp.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.beans.Transient;
import java.io.IOException;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Book uploadBook(BookRequest request
    ) throws IOException {
        //   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Author author = Author.builder().name(request.getAuthor()).build();
        authorRepository.save(author);
        Category category = Category.builder().name(request.getCategory()).build();
        categoryRepository.save(category);

        Book book = new Book();
        book.setAuthor(author);
        book.setCategory(category);

        book.setName(request.getName());

        book.setDescribe(request.getDescribe());

        book.setImg(request.getImg());

        //   book.setAuthor(authorRepository.f);

        //  book.setCategory(categoryRepository.findById(request.getCategory_id()).orElse(null));

        Book savedBook = bookRepository.save(book);

        //    String uploadDir = "book-photos/" + savedBook.getId();
        //  String filePath = uploadDir + "/" + fileName;
        //  FileUploadUtil.saveFile(uploadDir, fileName, file);

        //   savedBook.setFilePath(filePath);
        bookRepository.save(savedBook);

        return savedBook;
    }
}