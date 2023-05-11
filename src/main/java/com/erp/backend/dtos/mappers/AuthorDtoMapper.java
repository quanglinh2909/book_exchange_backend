package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.AuthorDto;
import com.erp.backend.dtos.UserDto;
import com.erp.backend.entities.Author;
import com.erp.backend.entities.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class AuthorDtoMapper implements Function<Author, AuthorDto> {
    @Override
    public AuthorDto apply(Author author) {
        return new AuthorDto(author.getAuthor_id(), author.getName(),author.getDescription());
    }
}
