package com.onevizion.booksonevizion.service;

import com.onevizion.booksonevizion.daos.JpaBookRepository;
import com.onevizion.booksonevizion.models.Book;
import com.onevizion.booksonevizion.models.SortModel;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final JpaBookRepository bookRepository;

    public BookService(JpaBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll(SortModel model) {
        return bookRepository.findAll(Sort.by(
                Sort.Direction.fromString(model.getType()),
                model.getProperties()));
    }

    public Map<String, Set<Book>> findAllGroupByAuthor() {
        return bookRepository.findAll().stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.mapping(book -> book, Collectors.toSet())));
    }
}
