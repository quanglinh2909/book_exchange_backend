package com.erp.backend.services;

import com.erp.backend.dtos.AuthorDto;
import com.erp.backend.dtos.mappers.AuthorDtoMapper;
import com.erp.backend.dtos.request.AuthorRequest;
import com.erp.backend.entities.Author;
import com.erp.backend.exceptions.ExitException;
import com.erp.backend.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    AuthorDtoMapper mapper;
    public Author getAuthorById(long id){
        return authorRepository.getAuthorById(id);
    }
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }
    public AuthorDto createAuthor(AuthorRequest request){

        Optional<Author> optionalAuthor=authorRepository.findByName(request.getName());
        if(optionalAuthor.isPresent()){
            throw new ExitException(HttpStatus.BAD_REQUEST,"Author is exits");
        }
        Author author=Author.builder()
                            .name(request.getName())
                            .description(request.getDescription())
                            .build();
        Author save=authorRepository.save(author);
        return mapper.apply(save);
    }
    public List<AuthorDto> getAll(){
        List<Author> list=authorRepository.findAll();
        List<AuthorDto> listResult=list.stream().map(mapper::apply).collect(Collectors.toList());
        return listResult;
    }
}
