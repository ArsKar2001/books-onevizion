package com.onevizion.booksonevizion.controllers;

import com.onevizion.booksonevizion.daos.JpaBookRepository;
import com.onevizion.booksonevizion.models.Book;
import com.onevizion.booksonevizion.models.SortModel;
import com.onevizion.booksonevizion.service.BookService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
class BookControllerTest {
    @Autowired
    private JpaBookRepository bookRepository;

    private BookService service;

    @BeforeEach
    void setUp() {
        service = new BookService(bookRepository);
    }

    @Test
    void saveBook() {
        Book book = new Book.Builder()
                .author("test")
                .description("test")
                .title("test")
                .build();
        Book save = service.save(book);
        assertEquals(book, save);
    }

    @Test
    void findAll() {
        List<Book> books = service.findAll(new SortModel(new String[]{"author"}, "asc"));
        assertNotNull(books);
    }

    @Test
    void testFindAll() {
        Map<String, Set<Book>> map = service.findAllGroupByAuthor();
        assertNotNull(map);
    }
}