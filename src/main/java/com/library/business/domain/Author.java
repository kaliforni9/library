package com.library.business.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
@EqualsAndHashCode(exclude = {"books", "id"})
@ToString(exclude = {"books"})
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String fio;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    private String email;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = Book_.AUTHOR)
    private List<Book> books;
}