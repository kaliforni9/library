package com.library.spring.controller;

import com.library.business.dto.AuthorDto;
import com.library.business.dto.BookDto;
import com.library.business.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/library/book")
@RequiredArgsConstructor
@EnableScheduling
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
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
    }

    @GetMapping(value = "/getAllBooks")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(value = "/deleteBook")
    public void deleteBook(@RequestBody BookDto bookDto) {
        bookService.deleteBook(bookDto);
    }

    @PutMapping(value = "/updateBook")
    public void updateBook(@RequestBody BookDto bookDto) {
        bookService.updateBook(bookDto);
    }

    @Scheduled(cron = "* */5 * * * *")
    public void getCountOfAllBooksEvery5Minutes() {
        Long countAllBooks = bookService.getCountAllBooks();
        log.info("Количество книг в базе: " + countAllBooks);
    }
}