package com.library.business.services.impl;

import com.library.business.dao.AuthorDao;
import com.library.business.domain.Author;
import com.library.business.dto.AuthorDto;
import com.library.business.mapping.AuthorMapping;
import com.library.business.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    private final AuthorMapping authorMapping;

    @Override
    public List<Author> getAllAuthor() {
        return authorDao.findAll();
    }

    @Override
    public void createAuthor(AuthorDto authorDto) {
        Author author = authorMapping.mapAuthorDtoToAuthor(authorDto);
        authorDao.save(author);
    }

    @Override
    public void deleteAuthor(AuthorDto authorDto) {
        Author author = authorMapping.mapAuthorDtoToAuthor(authorDto);
        authorDao.delete(author);
    }

    @Override
    public void updateAuthor(AuthorDto authorDto) {
        Author author = authorMapping.mapAuthorDtoToAuthor(authorDto);
        authorDao.save(author);
    }
}
