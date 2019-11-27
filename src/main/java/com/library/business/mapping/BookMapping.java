package com.library.business.mapping;

import com.library.business.domain.Author;
import com.library.business.domain.Book;
import com.library.business.dto.BookDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapping {

    BookDto map(Book book);

    Book map(BookDto bookDto);

    List<Book> mapListDto(List<BookDto> bookDto);

    List<BookDto> mapListEntities(List<Book> book);

    BookDto.AuthorDto map(Author author);

    Author map(BookDto.AuthorDto authorDto);

}
