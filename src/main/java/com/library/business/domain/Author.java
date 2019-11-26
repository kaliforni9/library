package com.library.business.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
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
    @Id
    @GeneratedValue(generator = "AUTHOR_SEQ")
    @GenericGenerator(
            name = "AUTHOR_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "AUTHOR_SEQ"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "FIO", nullable = false)
    private String fio;

    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "EMAIL")
    private String email;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = Book_.AUTHOR)
    private List<Book> books;
}
