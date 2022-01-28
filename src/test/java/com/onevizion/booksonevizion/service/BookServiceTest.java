package com.onevizion.booksonevizion.service;

import com.onevizion.booksonevizion.daos.JpaBookRepository;
import com.onevizion.booksonevizion.models.Book;
import com.onevizion.booksonevizion.models.SortModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
class BookServiceTest {

    @Autowired
    private JpaBookRepository bookRepository;

    private BookService service;

    @BeforeEach
    void setUp() {
        service = new BookService(bookRepository);
    }

    @Test
    void save() {
        Book book = service.save(new Book.Builder()
                .author("sdeff")
                .title("test")
                .description("test")
                .build());
        assertNotNull(book);
    }

    @Test
    void findAll() {
        List<Book> books = service.findAll(new SortModel(new String[]{"author"}, "asc"));
        assertNotNull(books);
    }

    @Test
    void findAllGroupByAuthor() {
        Map<String, Set<Book>> map = service.findAllGroupByAuthor();
        assertNotNull(map);
    }
}