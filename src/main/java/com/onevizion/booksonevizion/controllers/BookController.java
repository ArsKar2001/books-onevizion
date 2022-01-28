package com.onevizion.booksonevizion.controllers;

import com.onevizion.booksonevizion.models.Book;
import com.onevizion.booksonevizion.models.SortModel;
import com.onevizion.booksonevizion.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestBody SortModel model) {
        return ResponseEntity.ok(bookService.findAll(model));
    }

    @GetMapping("/authors")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAllGroupByAuthor());
    }
}
