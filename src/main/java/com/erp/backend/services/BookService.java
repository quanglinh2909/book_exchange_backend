package com.erp.backend.services;


import com.erp.backend.dtos.BookDTO;
import com.erp.backend.dtos.auth.BookDto;
import com.erp.backend.dtos.mappers.BookDTOMapper;
import com.erp.backend.dtos.request.BookRequest;
import com.erp.backend.dtos.request.UpdateBookRequest;
import com.erp.backend.entities.*;
import com.erp.backend.models.Response;
import com.erp.backend.repositories.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
    private UserRepository userRepository;
    @Autowired
    BookDTOMapper dtoMapper;

    public List<BookDTO> getAll() {
        List<Book> list = bookRepository.findAll();
        List<BookDTO> listResult = list.stream().map(dtoMapper::apply).collect(Collectors.toList());
        return listResult;
    }

    public BookDTO uploadBook(String jsonObject, MultipartFile[] images) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            BookRequest request = mapper.readValue(jsonObject, BookRequest.class);
            Category category = categoryRepository.findById(request.getIdCategory()).get();
            Optional<Author> optionalAuthor = authorRepository.findByName(request.getAuthorName());
            Author author;
            if (!optionalAuthor.isPresent()) {
                author = Author.builder().name(request.getAuthorName())
                        .build();
                author = authorRepository.save(author);
            } else {
                author = optionalAuthor.get();
            }
            Set<ImageModel> listImage = new HashSet<>();
            for (MultipartFile image : images) {
                try {
                    ImageModel imageModel = ImageModel.builder()
                            .name(image.getOriginalFilename())
                            .type(image.getContentType())
                            .picByte(image.getBytes())
                            .build();

                    ImageModel saveImage = imageRepository.save(imageModel);
                    listImage.add(saveImage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            User user = userRepository.findById(request.getIdUserCreate()).get();
            Book book = Book.builder()
                    .bookDescribe(request.getDescription())
                    .bookName(request.getName())
                    .category(category)
                    .author(author)
                    .productImages(listImage)
                    .userCreate(user)
                    .build();
            bookRepository.save(book);
            return dtoMapper.apply(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public BookDTO updateBook(String jsonObject, MultipartFile[] images) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            UpdateBookRequest request = mapper.readValue(jsonObject, UpdateBookRequest.class);
            Book book = bookRepository.findById(request.getId()).get();
            Category category = categoryRepository.findById(request.getIdCategory()).get();
            Optional<Author> optionalAuthor = authorRepository.findByName(request.getAuthorName());
            Author author;
            if (!optionalAuthor.isPresent()) {
                author = Author.builder().name(request.getAuthorName())
                        .build();
                author = authorRepository.save(author);
            } else {
                author = optionalAuthor.get();
            }
            Set<ImageModel> listImage = new HashSet<>();
            for (MultipartFile image : images) {
                try {
                    ImageModel imageModel = ImageModel.builder()
                            .name(image.getOriginalFilename())
                            .type(image.getContentType())
                            .picByte(image.getBytes())
                            .build();

                    ImageModel saveImage = imageRepository.save(imageModel);
                    listImage.add(saveImage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            book.setBookDescribe(request.getDescription());
            book.setBookName(request.getName());
            book.setAuthor(author);
            book.setCategory(category);
            book.setProductImages(listImage);
            bookRepository.save(book);
            return dtoMapper.apply(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public Response deleteBook(Long idBook) {
        Optional<Book> optionalBook = bookRepository.findById(idBook);
        Book book = optionalBook.get();
        bookRepository.delete(book);
        return new Response(200, null, null);
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

    public Book getBookById(long id) {
        return bookRepository.getBookById(id);
    }

    public List<Book> getBookByAuthor(long id) {
        return bookRepository.getBookByAuthor(id);
    }

    public List<Book> getBookByCategory(long id) {
        return bookRepository.getBookByCategory(id);
    }

}
