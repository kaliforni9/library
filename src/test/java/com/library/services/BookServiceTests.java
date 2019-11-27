package com.library.services;


import com.library.LibraryApplication;
import com.library.business.dto.BookDto;
import com.library.business.services.BookService;
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
public class BookServiceTests {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetAllBooks() {

        final List<BookDto> bookDtos = bookService.getAllBooks();
        assertThat(bookDtos.isEmpty(), is(false));
    }

    @Test
    public void testCreateBook() {

        final BookDto bookDto = new BookDto();

        bookDto.setName(BOOK_NAME);
        bookDto.setDescription(BOOK_DESCRIPTION);
        bookDto.setPageCount(BOOK_PAGE_COUNT);

        final BookDto createdBook = bookService.createBook(bookDto);

        assertThat(bookDto.getName(), is(BOOK_NAME));
        assertThat(bookDto.getDescription(), is(BOOK_DESCRIPTION));
        assertThat(bookDto.getPageCount(), is(BOOK_PAGE_COUNT));
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCreateBookWithNullParams() {

        final BookDto bookDto = new BookDto();

        bookDto.setName(null);
        bookDto.setDescription(null);
        bookDto.setPageCount(null);
        bookService.createBook(bookDto);
    }

    @Test
    public void testUpdateBook() {

        final BookDto bookDto = addTestBookDto();
        final BookDto newBookDto = new BookDto();

        newBookDto.setName(NEW_BOOK_NAME);
        newBookDto.setDescription(NEW_BOOK_DESCRIPTION);
        newBookDto.setPageCount(NEW_BOOK_PAGE_COUNT);

        final BookDto updatedBookDto = bookService.updateBook(newBookDto);

        assertThat(updatedBookDto.getId(), is(bookDto.getId()));
        assertThat(updatedBookDto.getName(), is(NEW_BOOK_NAME));
        assertThat(updatedBookDto.getDescription(), is(NEW_BOOK_DESCRIPTION));
        assertThat(updatedBookDto.getPageCount(), is(NEW_BOOK_PAGE_COUNT));
    }

    private BookDto addTestBookDto() {

        final BookDto bookDto = new BookDto();

        bookDto.setName(BOOK_NAME);
        bookDto.setDescription(BOOK_DESCRIPTION);
        bookDto.setPageCount(BOOK_PAGE_COUNT);

        return bookService.createBook(bookDto);
    }
}