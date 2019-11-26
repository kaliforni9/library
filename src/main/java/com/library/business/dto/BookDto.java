package com.library.business.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookDto {
    private Long id;
    private String name;
    private Long pageCount;
    private String description;
    private AuthorDto author;

    @Data
    public static class AuthorDto {
        private Long id;
        private String fio;
        private Date birthday;
        private String email;
    }
}
