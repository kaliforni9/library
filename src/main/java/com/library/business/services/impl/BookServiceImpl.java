package com.library.business.services.impl;

import com.library.business.dao.AuthorDao;
import com.library.business.dao.BookDao;
import com.library.business.domain.Author;
import com.library.business.domain.Book;
import com.library.business.dto.BookDto;
import com.library.business.exceptions.AlreadyExistException;
import com.library.business.exceptions.NotFoundException;
import com.library.business.mapping.BookMapping;
import com.library.business.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final AuthorDao authorDao;

    private final BookDao bookDao;

    private final BookMapping bookMapping;

    @Override
    public List<BookDto> getBookByName(String name) {
        return bookMapping.mapListEntities(bookDao.findAllByNameContainingIgnoreCaseOrderByName(name));
    }

    @Override
    public List<BookDto> getBooksByAuthor(String fio) {
        return bookMapping.mapListEntities(bookDao.findAllByAuthorFioContainingIgnoreCaseOrderByName(fio));
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookMapping.mapListEntities(bookDao.findAll());
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookMapping.map(bookDto);
        Optional<Author> author = authorDao.findById(bookDto.getAuthor().getId());
        if (author.isPresent()) {
            book.setAuthor(author.get());
        } else {
            throw new NotFoundException(String.format("Автор с ID = %s не найден", bookDto.getAuthor().getId()));
        }
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();
        Example<Book> example = Example.of(book, matcher);
        if (bookDao.findAll(example).size() > 0) {
            throw new AlreadyExistException("Такая книга уже есть");
        }
        return bookMapping.map(bookDao.save(book));
    }

    @Override
    public void deleteBook(BookDto bookDto) {
        Book book = bookMapping.map(bookDto);
        bookDao.delete(book);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Book book = bookMapping.map(bookDto);
        return bookMapping.map(bookDao.save(book));
    }

    @Override
    public Long getCountAllBooks() {
        return bookDao.count();
    }
}
