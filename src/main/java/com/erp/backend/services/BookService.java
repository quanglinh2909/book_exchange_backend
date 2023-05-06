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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.beans.Transient;
import java.io.IOException;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

<<<<<<< HEAD
    //<<<<<<< HEAD
=======
//<<<<<<< HEAD
>>>>>>> 8c2fcc47fc3037cedb2aa38575b5590b725daf17
////<<<<<<< HEAD
//=======
    @Transactional
    public Book uploadBook(BookRequest request) throws IOException {
        //   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Author author = Author.builder().name(request.getAuthor()).build();
        authorRepository.save(author);
        Category category = Category.builder().name(request.getCategory()).build();
        categoryRepository.save(category);

//>>>>>>> 498aa6380298d0c5fc0dcdd04f4b7e83c8a27364
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
//<<<<<<< HEAD
<<<<<<< HEAD

//=======
//    public Book uploadBook(BookRequest request
//                            ) throws IOException {
//     //   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        Book book = new Book();
//        book.setName(request.getName());
//>>>>>>> dev
//=======
//    }
//
//    public Book uploadBook(BookRequest request) throws IOException {
        //   String fileName = StringUtils.cleanPath(file.getOriginalFilename());

=======

//=======
//    public Book uploadBook(BookRequest request
//                            ) throws IOException {
//     //   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        Book book = new Book();
//        book.setName(request.getName());
//>>>>>>> dev
//=======
//    }
//
//    public Book uploadBook(BookRequest request) throws IOException {
     //   String fileName = StringUtils.cleanPath(file.getOriginalFilename());

>>>>>>> 8c2fcc47fc3037cedb2aa38575b5590b725daf17
        Book book = new Book();
        book.setAuthor(author);
        book.setCategory(category);

        book.setBookName(request.getName());

        book.setBookDescribe(request.getDescribe());

//        book.setImg(request.getImg());

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

//>>>>>>> 498aa6380298d0c5fc0dcdd04f4b7e83c8a27364

    public Book uploadNewBook(BookDto book) {
        Book book1 = new Book();
        Author author = authorRepository.findById(book.getAuthor()).get();
        Category category = categoryRepository.findById(book.getCategory()).get();
        book1.setAuthor(author);
        book1.setCategory(category);
        book1.setBookDescribe(book.getBookDescribe());
        book1.setBookName(book.getBookName());
        return bookRepository.save(book1);
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book getBookById(long id){
        return bookRepository.getBookById(id);
    }
    public List<Book> getBookByAuthor(long id){
        return bookRepository.getBookByAuthor(id);
    }
    public List<Book> getBookByCategory(long id){
        return bookRepository.getBookByCategory(id);
    }

}