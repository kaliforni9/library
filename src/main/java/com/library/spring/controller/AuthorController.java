package com.library.spring.controller;

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
    public void createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.createAuthor(authorDto);
    }

    @GetMapping(value = "/getAllAuthors")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthor();
    }

    @PostMapping(value = "/deleteAuthor")
    public void deleteAuthor(@RequestBody AuthorDto authorDto) {
        authorService.deleteAuthor(authorDto);
    }

    @PutMapping(value = "/updateAuthor")
    public void updateAuthor(@RequestBody AuthorDto authorDto) {
        authorService.updateAuthor(authorDto);
    }

    @GetMapping(value = "/createRandomAuthor")
    public AuthorDto createRandomAuthor(){
        return(authorService.createRandomAuthor());
    };
}