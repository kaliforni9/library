package com.library.business.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn
    private Author author;

    @Column(name = "page_count")
    private Long pageCount;

    private String description;
}