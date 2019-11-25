package com.library.spring.controller;

import com.library.business.dto.AuthorDto;
import com.library.business.dto.BookDto;
import com.library.business.mapping.AuthorMapping;
import com.library.business.mapping.BookMapping;
import com.library.business.services.AuthorService;
import com.library.business.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library")
@RequiredArgsConstructor
public class RedirectController {

    private final BookService bookService;

    private final AuthorService authorService;

    private final BookMapping bookMapping;

    private final AuthorMapping authorMapping;

    @PostMapping(value = "/getBookByName")
    public List<BookDto> getBookByName(@RequestBody BookDto bookDto) {
        return bookMapping.mapBookListToBookDtoList(bookService.getBookByName(bookDto.getName()));
    }

    @PostMapping(value = "/getBookByAuthor")
    public List<BookDto> getBookByAuthor(@RequestBody AuthorDto authorDto) {
        return bookMapping.mapBookListToBookDtoList(bookService.getBooksByAuthor(authorDto.getFio()));
    }

    @PostMapping(value = "/createBook")
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
    }

    @GetMapping(value = "/getAllBooks")
    public List<BookDto> getAllBooks() {
        return bookMapping.mapBookListToBookDtoList(bookService.getAllBooks());
    }

    @PostMapping(value = "/deleteBook")
    public void deleteBook(@RequestBody BookDto bookDto) {
        bookService.deleteBook(bookDto);
    }

    @PutMapping(value = "/updateBook")
    public void updateBook(@RequestBody BookDto bookDto) {
        bookService.updateBook(bookDto);
    }

    @PostMapping(value = "/createAuthor")
    public void createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.createAuthor(authorDto);
    }

    @GetMapping(value = "/getAllAuthors")
    public List<AuthorDto> getAllAuthors() {
        return authorMapping.mapAuthorListToAuthorDtoList(authorService.getAllAuthor());
    }

    @PostMapping(value = "/deleteAuthor")
    public void deleteAuthor(@RequestBody AuthorDto authorDto) {
        authorService.deleteAuthor(authorDto);
    }

    @PutMapping(value = "/updateAuthor")
    public void updateAuthor(@RequestBody AuthorDto authorDto) {
        authorService.updateAuthor(authorDto);
    }
}