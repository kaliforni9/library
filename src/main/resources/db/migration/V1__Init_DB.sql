create sequence author_seq;
create sequence book_seq;

create table author
(
    id       bigint       not null
        constraint pk_author_id primary key,
    fio      varchar(300) not null,
    birthday date,
    email    varchar(300)
);

create table book
(
    id          bigint        not null
        constraint pk_book_id primary key,
    name        varchar(2048) not null,
    author_id   bigint        not null
        constraint fk_author_id references author,
    description varchar(4096),
    page_count  int8
);
