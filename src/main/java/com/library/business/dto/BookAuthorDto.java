package com.library.business.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookAuthorDto {

    private Long id;
    private String fio;
    private Date birthday;
    private String email;

}
