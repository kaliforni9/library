package com.library.business.dto;

import lombok.Data;

@Data
public class AuthorBookDto {

    private Long id;
    private String name;
    private Long pageCount;
    private String description;

}
