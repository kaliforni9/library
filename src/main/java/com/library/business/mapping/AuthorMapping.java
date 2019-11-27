package com.library.business.mapping;

import com.library.business.domain.Author;
import com.library.business.domain.Book;
import com.library.business.dto.AuthorDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapping {

    AuthorDto map(Author author);

    Author map(AuthorDto authorDto);

    AuthorDto.BookDto mapAuthorBook(Book book);

    Book mapAuthorBook(AuthorDto.BookDto bookDto);

    List<Author> mapListDto(List<AuthorDto> authorDto);

    List<AuthorDto> mapListEntities(List<Author> author);

    List<Book> mapListBooksDto(List<AuthorDto.BookDto> bookDto);

    List<AuthorDto.BookDto> mapListBooksEntities(List<Book> book);

}