package com.library.business.services;

import com.library.business.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAllAuthor();

    AuthorDto createAuthor(AuthorDto authorDto);

    void deleteAuthor(AuthorDto authorDto);

    AuthorDto updateAuthor(AuthorDto authorDto);

    AuthorDto createRandomAuthor();

}
