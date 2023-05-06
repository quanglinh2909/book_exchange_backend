package com.erp.backend.controllers;

import com.erp.backend.dtos.BookDto;
import com.erp.backend.dtos.auth.BookRequest;
import com.erp.backend.entities.Book;
import com.erp.backend.entities.ImageModel;
import com.erp.backend.repositories.AuthorRepository;
import com.erp.backend.repositories.BookRepository;
import com.erp.backend.repositories.CategoryRepository;
import com.erp.backend.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
>>>>>>> 8c2fcc47fc3037cedb2aa38575b5590b725daf17
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookService service;
    @PostMapping("/books/upload")
    public ResponseEntity<?> uploadBook(@RequestBody @Valid BookRequest request
                                         ) throws IOException {
       // Book savedBook = service.uploadBook(name,describe,img,id_author,id_category);

//        return ResponseEntity.ok(service.uploadBook(request));
      //  return ResponseEntity.ok(savedBook);
        return null;
    }

    @PostMapping(value = {"/books/uploadNewBook"})
    public Book addNewBook(@RequestBody @Valid  BookDto book) {

//        try {
//            Set<ImageModel> images = uploadImage(file);
//            book.setProductImages(images);
//            return service.uploadNewBook(book);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
        return service.uploadNewBook(book);
    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();
        for (MultipartFile file : multipartFiles) {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    @GetMapping({"/getAllBooks"})
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }
    @GetMapping("/book/{authorId}")
    public String viewBookByAuthor(ModelMap modelMap, @PathVariable("authorID") long authorID){
        List<Book> books = service.getAllBooks();
        modelMap.put("books",books);
        modelMap.put("authors",service.getBookByAuthor(authorID));
        return "";
    }
    @GetMapping("/book/{categoryId}")
    public String viewBookByCategory(ModelMap modelMap, @PathVariable("categoryId") long categoryId){
        List<Book> books = service.getAllBooks();
        modelMap.put("books",books);
        modelMap.put("category",service.getBookByCategory(categoryId));
        return "";
    }

}
