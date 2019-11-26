package com.library.business.services.impl;

import com.library.business.dao.AuthorDao;
import com.library.business.domain.Author;
import com.library.business.dto.AuthorDto;
import com.library.business.exceptions.AlreadyExistException;
import com.library.business.mapping.AuthorMapping;
import com.library.business.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    private final AuthorMapping authorMapping;

    @Override
    public List<AuthorDto> getAllAuthor() {
        return authorMapping.mapListEntities(authorDao.findAll());
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = authorMapping.map(authorDto);
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();
        Example<Author> example = Example.of(author, matcher);
        if (authorDao.findAll(example).size() > 0) {
            throw new AlreadyExistException("Такой автор уже есть");
        }
        return authorMapping.map(authorDao.save(author));
    }

    @Override
    public boolean deleteAuthor(AuthorDto authorDto) {
        Author author = authorMapping.map(authorDto);
        authorDao.delete(author);
        return authorDao.existsById(author.getId());
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        Author author = authorMapping.map(authorDto);
        return authorMapping.map(authorDao.save(author));
    }
}
