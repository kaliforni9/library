package com.library.services;

import com.library.LibraryApplication;
import com.library.business.dto.AuthorDto;
import com.library.business.services.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static com.library.Tests.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class)
public class AuthorServiceTests {

    @Autowired
    private AuthorService authorService;

    @Test
    public void testGetAllAuthors() {

        final List<AuthorDto> authorList = authorService.getAllAuthor();
        assertThat(authorList.isEmpty(), is(false));
    }

    @Test
    public void testCreateAuthor() {

        final AuthorDto authorDto = new AuthorDto();

        authorDto.setFio(AUTHOR_FIO);
        authorDto.setBirthday(AUTHOR_BIRTHDAY);
        authorDto.setEmail(AUTHOR_EMAIL);

        final AuthorDto createdAuthor = authorService.createAuthor(authorDto);

        assertThat(createdAuthor.getFio(), is(AUTHOR_FIO));
        assertThat(createdAuthor.getBirthday(), is(AUTHOR_BIRTHDAY));
        assertThat(createdAuthor.getEmail(), is(AUTHOR_EMAIL));
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCreateAuthorWithNullParams() {

        final AuthorDto authorDto = new AuthorDto();

        authorDto.setFio(null);
        authorDto.setBirthday(null);
        authorDto.setEmail(null);
        authorService.createAuthor(authorDto);
    }

    @Test
    public void testUpdateAuthor() {

        final AuthorDto authorDto = addTestAuthorDto();
        final AuthorDto newAuthorDto = new AuthorDto();

        newAuthorDto.setFio(NEW_AUTHOR_FIO);
        newAuthorDto.setBirthday(NEW_AUTHOR_BIRTHDAY);
        newAuthorDto.setEmail(NEW_AUTHOR_EMAIL);

        final AuthorDto updatedAuthorDto = authorService.updateAuthor(newAuthorDto);

        assertThat(updatedAuthorDto.getId(), is(authorDto.getId()));
        assertThat(updatedAuthorDto.getFio(), is(NEW_AUTHOR_FIO));
        assertThat(updatedAuthorDto.getBirthday(), is(NEW_AUTHOR_BIRTHDAY));
        assertThat(updatedAuthorDto.getEmail(), is(NEW_AUTHOR_EMAIL));
    }

    private AuthorDto addTestAuthorDto() {

        AuthorDto authorDto = new AuthorDto();
        authorDto.setFio(AUTHOR_FIO);
        authorDto.setBirthday(AUTHOR_BIRTHDAY);
        authorDto.setEmail(AUTHOR_EMAIL);

        return authorService.createAuthor(authorDto);
    }
}
