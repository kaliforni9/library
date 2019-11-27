package com.library.business.services.impl;

import com.library.business.dao.AuthorDao;
import com.library.business.domain.Author;
import com.library.business.domain.RandomAuthor;
import com.library.business.dto.AuthorDto;
import com.library.business.exceptions.AlreadyExistException;
import com.library.business.mapping.AuthorMapping;
import com.library.business.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    private final AuthorMapping authorMapping;

    @Override
    @Transactional
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
    public void deleteAuthor(AuthorDto authorDto) {
        Author author = authorMapping.map(authorDto);
        authorDao.delete(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        Author author = authorMapping.map(authorDto);
        return authorMapping.map(authorDao.save(author));
    }

    @Override
    public AuthorDto createRandomAuthor() {
        AuthorDto authorDto = new AuthorDto();
        RandomAuthor randomAuthor = RandomAuthor.getAuthor();
        authorDto.setFio(randomAuthor.getName().toString());
        authorDto.setEmail(randomAuthor.getEmail());
        try {
            authorDto.setBirthday(new SimpleDateFormat("YYYY-MM-dd").parse(randomAuthor.getDob().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        createAuthor(authorDto);
        return authorDto;
    }
}
