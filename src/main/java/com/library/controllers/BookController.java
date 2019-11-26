package com.library.controllers;

import com.library.business.dto.AuthorDto;
import com.library.business.dto.BookDto;
import com.library.business.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping(value = "/getBookByName")
    public List<BookDto> getBookByName(@RequestBody BookDto bookDto) {
        return bookService.getBookByName(bookDto.getName());
    }

    @PostMapping(value = "/getBookByAuthor")
    public List<BookDto> getBookByAuthor(@RequestBody AuthorDto authorDto) {
        return bookService.getBooksByAuthor(authorDto.getFio());
    }

    @PostMapping(value = "/createBook")
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @GetMapping(value = "/getAllBooks")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(value = "/deleteBook")
    public boolean deleteBook(@RequestBody BookDto bookDto) {
        return bookService.deleteBook(bookDto);
    }

    @PutMapping(value = "/updateBook")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookService.updateBook(bookDto);
    }
}
