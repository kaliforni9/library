package com.library.business.dao;

import com.library.business.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthorFioContainingIgnoreCaseOrderByName(String fio);

    List<Book>  findAllByNameContainingIgnoreCaseOrderByName(String name);
}
