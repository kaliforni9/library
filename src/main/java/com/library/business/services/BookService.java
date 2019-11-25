package com.library.business.services;

import com.library.business.domain.Book;
import com.library.business.dto.BookDto;

import java.util.List;

public interface BookService {

    List<Book>  getBookByName(String name);

    List<Book> getBooksByAuthor(String fio);

    List<Book> getAllBooks();

    void createBook(BookDto bookDto);

    void deleteBook(BookDto bookDto);

    void updateBook(BookDto bookDto);
}
