package com.erp.backend.services;


import com.erp.backend.dtos.BookDTO;
import com.erp.backend.dtos.auth.BookDto;
import com.erp.backend.dtos.mappers.BookDTOMapper;
import com.erp.backend.dtos.request.BookRequest;
import com.erp.backend.entities.Author;
import com.erp.backend.entities.Book;
import com.erp.backend.entities.Category;
import com.erp.backend.entities.ImageModel;
import com.erp.backend.repositories.AuthorRepository;
import com.erp.backend.repositories.BookRepository;
import com.erp.backend.repositories.CategoryRepository;
import com.erp.backend.repositories.ImageModelRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ImageModelRepository imageRepository;
    @Autowired
    BookDTOMapper dtoMapper;
    public List<BookDTO> getAll(){
        List<Book> list=bookRepository.findAll();
        List<BookDTO> listResult=list.stream().map(dtoMapper::apply).collect(Collectors.toList());
        return listResult;
    }
    public BookDTO uploadBook(String jsonObject, MultipartFile[] images){
        ObjectMapper mapper=new ObjectMapper();
        try {
            BookRequest request=mapper.readValue(jsonObject,BookRequest.class);
            Category category=categoryRepository.findById(request.getIdCategory()).get();
            Author author=authorRepository.findById(request.getIdAuthor()).get();

            Set<ImageModel> listImage=new HashSet<>();
            for(MultipartFile image:images){
                try {
                    ImageModel imageModel=ImageModel.builder()
                            .name(image.getOriginalFilename())
                            .type(image.getContentType())
                            .picByte(image.getBytes())
                            .build();

                    ImageModel saveImage=imageRepository.save(imageModel);
                    listImage.add(saveImage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            Book book=Book.builder()
                    .bookDescribe(request.getDescription())
                    .bookName(request.getName())
                    .category(category)
                    .author(author)
                    .productImages(listImage)
                    .build();
            bookRepository.save(book);
            return dtoMapper.apply(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
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
