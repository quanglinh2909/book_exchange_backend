package com.erp.backend.controllers;

import com.erp.backend.dtos.BookDTO;
import com.erp.backend.dtos.HomeCateGoryBookDto;
import com.erp.backend.dtos.auth.BookDto;

import com.erp.backend.entities.Book;
import com.erp.backend.entities.ImageModel;
import com.erp.backend.repositories.AuthorRepository;
import com.erp.backend.repositories.BookRepository;
import com.erp.backend.repositories.CategoryRepository;
import com.erp.backend.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
    @PostMapping(value = "/books/create",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> uploadBook( @RequestParam(value ="book") String jsonObject,
                                         @RequestParam(value = "image",required = false) MultipartFile image){
        return ResponseEntity.ok(service.uploadBook(jsonObject,image));
    }

    @PostMapping(value = {"/books/uploadNewBook"})
    public Book addNewBook(@RequestBody @Valid  BookDto book) {
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
    @DeleteMapping("books/delete/{idBook}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "idBook") Long idBook){
        return ResponseEntity.ok(service.deleteBook(idBook));
    }
    @GetMapping({"books/getAll"})
    public List<BookDTO> getAll() {
        return service.getAll();
    }
    @GetMapping({"books/getAll/{idUser}"})
    public List<BookDTO> getAllBookOfUser(@PathVariable(value = "idUser") Long idUser) {
        return service.getAllOfUser(idUser);
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
    @PutMapping({"/book/favorite/{idBook}"})
    public ResponseEntity<?> favorite(@RequestAttribute("email") String email,@PathVariable(value = "idBook") Long idBook){
        return ResponseEntity.ok(service.favorite(email,idBook));
    }
    @PutMapping({"/book/unfavorite/{idBook}"})
    public ResponseEntity<?> unfavorite(@RequestAttribute("email") String email,@PathVariable(value = "idBook") Long idBook){
        return ResponseEntity.ok(service.unfavorite(email,idBook));
    }
    @GetMapping("/book/get/{idBook}")
    public ResponseEntity<?> getBook(@PathVariable("idBook") Long idBook){
        return ResponseEntity.ok(service.getBook(idBook));
    }
    @GetMapping("/book/{categoryId}")
    public String viewBookByCategory(ModelMap modelMap, @PathVariable("categoryId") long categoryId){
        List<Book> books = service.getAllBooks();
        modelMap.put("books",books);
        modelMap.put("category",service.getBookByCategory(categoryId));
        return "";
    }
    @GetMapping("/topbook")
    public List<Book> viewTopBook(ModelMap modelMap){
        List<Book> lstBook = service.topBook();
        modelMap.put("books",lstBook);
        return lstBook;
    }
    @GetMapping("/topbookCategory")
    public List<HomeCateGoryBookDto> viewTopBookByNameCategory(ModelMap modelMap){
        List<HomeCateGoryBookDto> lstBook = service.topBookByNameCategory();
        modelMap.put("books",lstBook);
        return lstBook;
    }
    @GetMapping("/topBookAuthor")
    public ResponseEntity<?> viewTopBookAuthor(){
        List<HomeCateGoryBookDto> lstBook = service.topBookByNameAuthor();
        return ResponseEntity.ok(lstBook);
    }
}
