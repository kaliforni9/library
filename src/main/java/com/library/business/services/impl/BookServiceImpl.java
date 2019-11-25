package com.library.business.services.impl;

import com.library.business.dao.AuthorDao;
import com.library.business.dao.BookDao;
import com.library.business.domain.Book;
import com.library.business.dto.BookDto;
import com.library.business.mapping.BookMapping;
import com.library.business.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final AuthorDao authorDao;

    private final BookDao bookDao;

    private final BookMapping bookMapping;

    @Override
    public List<Book> getBookByName(String name) {
        return bookDao.findAllByNameContainingIgnoreCaseOrderByName(name);
    }

    @Override
    public List<Book> getBooksByAuthor(String fio) {
        return bookDao.findAllByAuthorFioContainingIgnoreCaseOrderByName(fio);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public void createBook(BookDto bookDto) {
        Book book = bookMapping.mapBookDtoToBook(bookDto);
        book.setAuthor(authorDao.findById(bookDto.getAuthor().getId()).get());
        bookDao.save(book);
    }

    @Override
    public void deleteBook(BookDto bookDto) {
        Book book = bookMapping.mapBookDtoToBook(bookDto);
        bookDao.delete(book);
    }

    @Override
    public void updateBook(BookDto bookDto) {
        Book book = bookMapping.mapBookDtoToBook(bookDto);
        bookDao.save(book);
    }
}
