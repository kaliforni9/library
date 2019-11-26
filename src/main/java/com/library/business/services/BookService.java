package com.library.business.services;

import com.library.business.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getBookByName(String name);

    List<BookDto> getBooksByAuthor(String fio);

    List<BookDto> getAllBooks();

    BookDto createBook(BookDto bookDto);

    boolean deleteBook(BookDto bookDto);

    BookDto updateBook(BookDto bookDto);
}
