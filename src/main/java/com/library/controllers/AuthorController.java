package com.library.controllers;

import com.library.business.dto.AuthorDto;
import com.library.business.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping(value = "/createAuthor")
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }

    @GetMapping(value = "/getAllAuthors")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthor();
    }

    @PostMapping(value = "/deleteAuthor")
    public boolean deleteAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.deleteAuthor(authorDto);
    }

    @PutMapping(value = "/updateAuthor")
    public AuthorDto updateAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.updateAuthor(authorDto);
    }
}
