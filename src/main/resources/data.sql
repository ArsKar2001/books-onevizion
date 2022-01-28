drop table if exists BOOK;

create table BOOK
(
    ID          NUMBER auto_increment
        constraint BOOK_PK
            primary key,
    TITLE       VARCHAR2(150) not null,
    AUTHOR      VARCHAR2(150) not null,
    DESCRIPTION VARCHAR2(150)
);

create unique index BOOK_ID_UINDEX
    on BOOK (ID);

INSERT INTO BOOK(TITLE, AUTHOR, DESCRIPTION)
VALUES ('test1', 'test1', 'test1'),
       ('test2', 'test2', 'test1'),
       ('test3', 'test3', 'test1'),
       ('test4', 'test4', 'test1'),
       ('test5', 'test1', 'test1'),
       ('test6', 'test1', 'test1'),
       ('test7', 'test1', 'test1'),
       ('test8', 'test1', 'test1')