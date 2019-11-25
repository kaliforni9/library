package com.library.business.dto;

import lombok.Data;

@Data
public class BookDto {

    private Long id;
    private String name;
    private Long pageCount;
    private String description;
    private BookAuthorDto author;

}
