package com.library.business.mapping;

import com.library.business.domain.Book;
import com.library.business.dto.BookAuthorDto;
import com.library.business.dto.BookDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapping {

    BookDto mapBookToBookDto(Book book);

    Book mapBookDtoToBook(BookDto bookDto);

    List<Book> mapBookDtoListToBookList(List<BookDto> bookDto);

    List<BookDto> mapBookListToBookDtoList(List<Book> book);

    BookAuthorDto mapBookToBookAuthorDto(Book book);

    Book mapBookAuthorDtoToBook(BookAuthorDto bookDto);

}
