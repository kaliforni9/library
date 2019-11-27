package com.library.business.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Data
@Entity
@Table
@EqualsAndHashCode(exclude = {"author", "id"})
@ToString(exclude = {"author"})
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(generator = "BOOK_SEQ")
    @GenericGenerator(
            name = "BOOK_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "BOOK_SEQ"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @Column(name = "PAGE_COUNT")
    private Long pageCount;

    @Column(name = "DESCRIPTION")
    private String description;
}