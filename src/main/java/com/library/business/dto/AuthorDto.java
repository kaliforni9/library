package com.library.business.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AuthorDto {

    private Long id;
    private String fio;
    private Date birthday;
    private String email;
    private List<AuthorBookDto> books;

}
