package com.library.business.services;

import com.library.business.domain.Author;
import com.library.business.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();

    void createAuthor(AuthorDto authorDto);

    void deleteAuthor(AuthorDto authorDto);

    void updateAuthor(AuthorDto authorDto);

}
