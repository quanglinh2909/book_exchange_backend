package com.erp.backend.services;


import com.erp.backend.dtos.BookDTO;
import com.erp.backend.dtos.HomeCateGoryBookDto;
import com.erp.backend.dtos.auth.BookDto;
import com.erp.backend.dtos.mappers.BookDTOMapper;
import com.erp.backend.dtos.request.BookRequest;
import com.erp.backend.dtos.request.UpdateBookRequest;
import com.erp.backend.dtos.resonse.HomeBook;
import com.erp.backend.entities.*;
import com.erp.backend.models.Response;
import com.erp.backend.repositories.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
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
    private UploadService uploadService;
    @Autowired
    BookDTOMapper dtoMapper;
    public List<BookDTO> getAll(){
        List<Book> list=bookRepository.findAll();
        List<BookDTO> listResult=list.stream().map(dtoMapper::apply).collect(Collectors.toList());
        return listResult;
    }
    public List<BookDTO> getAllOfUser(Long idUser){
        List<Book> list=bookRepository.getBookByUser(idUser);
        List<BookDTO> listResult=list.stream().map(dtoMapper::apply).collect(Collectors.toList());
        return listResult;
    }
    public BookDTO uploadBook(String jsonObject, MultipartFile image){
        ObjectMapper mapper=new ObjectMapper();
        try {
            BookRequest request=mapper.readValue(jsonObject,BookRequest.class);
            Category category=categoryRepository.findById(request.getIdCategory()).get();
            Optional<Author> optionalAuthor=authorRepository.findByName(request.getAuthorName());
            Author author;
            if(!optionalAuthor.isPresent()){
                author=Author.builder().name(request.getAuthorName())
                        .build();
                author=authorRepository.save(author);
            }
            else{
                author=optionalAuthor.get();
            }

            User user=userRepository.findById(request.getIdUserCreate()).get();
            String url;
            try {
               url =uploadService.uploadFile(image,"upload");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Book book=Book.builder()
                    .bookDescribe(request.getDescription())
                    .bookName(request.getName())
                    .category(category)
                    .author(author)
                    .image(url)
                    .userCreate(user)
                    .build();
            bookRepository.save(book);
            return dtoMapper.apply(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
//    public BookDTO updateBook(String jsonObject, MultipartFile[] images){
//        ObjectMapper mapper=new ObjectMapper();
//        try {
//            UpdateBookRequest request=mapper.readValue(jsonObject,UpdateBookRequest.class);
//            Book book=bookRepository.findById(request.getId()).get();
//            Category category=categoryRepository.findById(request.getIdCategory()).get();
//            Optional<Author> optionalAuthor=authorRepository.findByName(request.getAuthorName());
//            Author author;
//            if(!optionalAuthor.isPresent()){
//                author=Author.builder().name(request.getAuthorName())
//                        .build();
//                author=authorRepository.save(author);
//            }
//            else{
//                author=optionalAuthor.get();
//            }
//            Set<ImageModel> listImage=new HashSet<>();
//            for(MultipartFile image:images){
//                try {
//                    ImageModel imageModel=ImageModel.builder()
//                            .name(image.getOriginalFilename())
//                            .type(image.getContentType())
//                            .picByte(image.getBytes())
//                            .build();
//
//                    ImageModel saveImage=imageRepository.save(imageModel);
//                    listImage.add(saveImage);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            book.setBookDescribe(request.getDescription());
//            book.setBookName(request.getName());
//            book.setAuthor(author);
//            book.setCategory(category);
//            book.setProductImages(listImage);
//            bookRepository.save(book);
//            return dtoMapper.apply(book);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    public Response deleteBook (Long idBook){
        Optional<Book> optionalBook=bookRepository.findById(idBook);
        Book book=optionalBook.get();
        bookRepository.delete(book);
        return new Response(200,null,null);
    }
    @Transactional
    public Book favorite(String email,Long idBook){
        User user=userRepository.findByEmail(email).get();
        System.out.println("1");
        Book book=bookRepository.findById(idBook).get();
        System.out.println("2");
        user.getFollows().add(book);
        System.out.println("3");
        userRepository.save(user);
        System.out.println("4");
        return book;
    }
    @Transactional
    public Book unfavorite(String email,Long idBook){
        User user=userRepository.findByEmail(email).get();
        Book book=bookRepository.findById(idBook).get();
        user.getFollows().remove(book);
        userRepository.save(user);
        return book;
    }
    public  BookDTO getBook(Long idBook){
        Book book=bookRepository.findById(idBook).get();
        return dtoMapper.apply(book);
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
//    public void getAllHomeBook(){
//        List<HomeBook> topRecent=new ArrayList<>();
//        List<Book> list=bookRepository.findTopRecent();
//        System.out.println(list);
//
//    }

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
    public List<Book> topBook(){
        return bookRepository.topBook();
    }
    public List<Book> topBookAuthor(){
        return bookRepository.topBookAuthor();
    }
    public  List<HomeCateGoryBookDto> topBookByNameCategory(){
        List<Category> list =categoryRepository.findAllByOrderByNameAsc();
        List<HomeCateGoryBookDto> result = new ArrayList<>();
        for (Category c: list) {
            List<Book> bookList= bookRepository.getBookByCategory(c.getCategory_id());

            result.add(new HomeCateGoryBookDto(c.getName(),bookList));
        }
        return result;
    }
    public  List<HomeCateGoryBookDto> topBookByNameAuthor(){
        List<Author> list =authorRepository.findAllByOrderByNameAsc();
        List<HomeCateGoryBookDto> result = new ArrayList<>();
        for (Author a: list) {
            List<Book> bookList= bookRepository.getBookByAuthor(a.getAuthor_id());
            result.add(new HomeCateGoryBookDto(a.getName(),bookList));
        }
        return result;
    }
}
