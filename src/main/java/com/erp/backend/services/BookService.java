package com.erp.backend.services;


import com.erp.backend.dtos.BookDto;
import com.erp.backend.dtos.auth.BookRequest;
import com.erp.backend.entities.Author;
import com.erp.backend.entities.Book;
import com.erp.backend.entities.Category;
import com.erp.backend.repositories.AuthorRepository;
import com.erp.backend.repositories.BookRepository;
import com.erp.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

<<<<<<< HEAD
//    public Book uploadBook(BookRequest request
//    ) throws IOException {
//        //   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        Book book = new Book();
//        book.setBookName(request.getBookName());
//
//        book.setBookDescribe(request.getBookDescribe());
//        book.setCategory(request.getCategory());
//        book.setAuthor(request.getAuthor());
//        book.setProductImages(request.getProductImages());
//
////        book.setImg(request.getImg());
//
////        book.setAuthor(authorRepository.findById(request.getAuthor_id()).orElse(null));
////
////        book.setCategory(categoryRepository.findById(request.getCategory_id()).orElse(null));
//
//        Book savedBook = bookRepository.save(book);
//
//        //    String uploadDir = "book-photos/" + savedBook.getId();
//        //  String filePath = uploadDir + "/" + fileName;
//        //  FileUploadUtil.saveFile(uploadDir, fileName, file);
//
//        //   savedBook.setFilePath(filePath);
//        bookRepository.save(savedBook);
//
//        return savedBook;
//    }

=======
    public Book uploadBook(BookRequest request
                            ) throws IOException {
     //   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Book book = new Book();
        book.setName(request.getName());
>>>>>>> dev

    public Book uploadNewBook(BookDto book) {
        Book book1 = new Book();
        Author author=authorRepository.findById(book.getAuthor()).get();
        Category category=categoryRepository.findById(book.getCategory()).get();
        book1.setAuthor(author);
        book1.setCategory(category);
        book1.setBookDescribe(book.getBookDescribe());
        book1.setBookName(book.getBookName());
        return bookRepository.save(book1);
    }

}