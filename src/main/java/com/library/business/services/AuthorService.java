package com.library.business.services;

import com.library.business.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAllAuthor();

    AuthorDto createAuthor(AuthorDto authorDto);

    boolean deleteAuthor(AuthorDto authorDto);

    AuthorDto updateAuthor(AuthorDto authorDto);
}
