package com.library.business.mapping;

import com.library.business.domain.Author;
import com.library.business.domain.Book;
import com.library.business.dto.AuthorBookDto;
import com.library.business.dto.AuthorDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapping {

    AuthorDto mapAuthorToAuthorDto(Author author);

    Author mapAuthorDtoToAuthor(AuthorDto authorDto);

    AuthorBookDto mapBookToAuthorBookDto(Book book);

    Book mapAuthorBookDtoToBook(AuthorBookDto bookDto);

    List<Author> mapAuthorDtoListToAuthor(List<AuthorDto> authorDto);

    List<AuthorDto> mapAuthorListToAuthorDtoList(List<Author> author);

    List<Book> mapAuthorBookDtoListToBookList(List<AuthorBookDto> bookDto);

    List<AuthorBookDto> mapBookListToAuthorBookDtoList(List<Book> book);

}