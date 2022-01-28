package com.onevizion.booksonevizion.daos;

import com.onevizion.booksonevizion.models.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class BookRepositoryTest {
    @Autowired
    private JpaBookRepository bookRepository;

    @Test
    public void saveBookTest() {
        Book book = new Book.Builder()
                .author("test")
                .description("test")
                .title("test")
                .build();
        Book save = bookRepository.save(book);
        Assert.assertEquals(book, save);
    }

    @Test
    public void findAllBooks() {
        List<Book> books = bookRepository.findAll();
        Assert.assertNotNull(books);
    }
}

